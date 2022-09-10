package br.ailtonbsj.jwtspringsecurity.service;

import java.util.List;

import br.ailtonbsj.jwtspringsecurity.domain.Role;
import br.ailtonbsj.jwtspringsecurity.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUser(String username);
    List<User> getUsers();
}
