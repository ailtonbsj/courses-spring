package br.ailtonbsj.jwtspringsecurity.api;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ailtonbsj.jwtspringsecurity.domain.RoleModel;
import br.ailtonbsj.jwtspringsecurity.domain.UserModel;
import br.ailtonbsj.jwtspringsecurity.dto.RoleToUserFormDTO;
import br.ailtonbsj.jwtspringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleModel> saveRole(@RequestBody RoleModel role) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserFormDTO dto) {
        userService.addRoleToUser(dto.getUsername(), dto.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String token = authHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String username = decodedJWT.getSubject();
                UserModel user = userService.getUser(username);
                String accessToken = JWT.create().withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withClaim("roles", user.getRoles().stream()
                                .map(RoleModel::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);
                tokens.put("refresh_token", token);
                res.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(res.getOutputStream(), tokens);
            } catch (Exception e) {
                res.setStatus(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                res.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(res.getOutputStream(), error);
            }

        } else {
            throw new RuntimeException("Refresh token is missing.");
        }
    }

}
