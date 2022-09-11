package br.ailtonbsj.jwtspringsecurity.service;

import java.util.List;

import br.ailtonbsj.jwtspringsecurity.domain.RoleModel;
import br.ailtonbsj.jwtspringsecurity.domain.UserModel;

public interface UserService {
    UserModel saveUser(UserModel user);
    RoleModel saveRole(RoleModel role);
    void addRoleToUser(String username, String role);
    UserModel getUser(String username);
    List<UserModel> getUsers();
}
