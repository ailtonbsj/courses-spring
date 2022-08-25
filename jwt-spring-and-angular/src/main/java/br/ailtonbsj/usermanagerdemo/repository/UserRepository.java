package br.ailtonbsj.usermanagerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ailtonbsj.usermanagerdemo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
