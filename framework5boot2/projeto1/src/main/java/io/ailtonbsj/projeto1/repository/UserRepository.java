package io.ailtonbsj.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.ailtonbsj.projeto1.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {
	
	User findByName(String name);
	
//	@Query("select u from User u where u.name like %?1%")
//	User findBySubtringName(String name);
	
}
