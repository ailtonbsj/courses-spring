package br.ailtonbsj.jwtspringsecurity.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
}
