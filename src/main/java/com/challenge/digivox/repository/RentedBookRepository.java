package com.challenge.digivox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.digivox.models.RentedBook;

public interface RentedBookRepository extends JpaRepository<RentedBook, Long> {
	Optional<RentedBook> findById(Long id);

}
