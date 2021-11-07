package io.ailtonbsj.projeto1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ailtonbsj.projeto1.StatusRole;
import io.ailtonbsj.projeto1.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByStatus(StatusRole status);
	
	Page<Role> findAll(Pageable pagleable);
	
	Role findByName(String name);
}
