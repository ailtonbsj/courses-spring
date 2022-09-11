package br.ailtonbsj.jwtspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ailtonbsj.jwtspringsecurity.domain.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    RoleModel findByName(String name);
}
