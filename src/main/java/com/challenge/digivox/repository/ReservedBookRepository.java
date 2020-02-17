package com.challenge.digivox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.digivox.models.ReservedBook;

public interface ReservedBookRepository extends JpaRepository<ReservedBook, Long> {

	Optional<ReservedBook> findById(Long id);
	
}
