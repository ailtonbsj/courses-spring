package io.ailtonbsj.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ailtonbsj.projeto1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByNameIgnoreCase(String name);
	
	@Query("SELECT u FROM User u WHERE u.email LIKE %?1%")
	User findBySliceEmail(String sliceMail);
}
