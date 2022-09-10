package br.ailtonbsj.jwtspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ailtonbsj.jwtspringsecurity.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
