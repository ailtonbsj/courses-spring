package io.ailtonbsj.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ailtonbsj.projeto1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
