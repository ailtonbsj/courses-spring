package br.ailtonbsj.jwtspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ailtonbsj.jwtspringsecurity.domain.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
