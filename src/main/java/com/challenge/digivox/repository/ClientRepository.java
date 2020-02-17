package com.challenge.digivox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.digivox.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findById(Long id);
}
