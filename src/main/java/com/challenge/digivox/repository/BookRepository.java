package com.challenge.digivox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.digivox.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {


	Optional<Book> findById(Long id);
}
