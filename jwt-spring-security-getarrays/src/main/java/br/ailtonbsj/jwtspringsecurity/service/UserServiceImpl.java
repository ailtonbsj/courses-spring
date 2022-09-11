package br.ailtonbsj.jwtspringsecurity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ailtonbsj.jwtspringsecurity.domain.RoleModel;
import br.ailtonbsj.jwtspringsecurity.domain.UserModel;
import br.ailtonbsj.jwtspringsecurity.repository.RoleRepository;
import br.ailtonbsj.jwtspringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserModel saveUser(UserModel user) {
        log.info("Saving new user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public RoleModel saveRole(RoleModel role) {
        log.info("Saving new role {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserModel user = userRepository.findByUsername(username);
        RoleModel role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserModel getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username);
        log.info("FETCHING PER USER {}", user);
        if (user == null) {
            String msg = "User not found in database";
            log.error(msg);
            throw new UsernameNotFoundException(msg);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
            authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
