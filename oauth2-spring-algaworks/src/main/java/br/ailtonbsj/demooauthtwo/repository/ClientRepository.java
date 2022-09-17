package br.ailtonbsj.demooauthtwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ailtonbsj.demooauthtwo.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
