package com.challenge.digivox.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.digivox.models.Book;
import com.challenge.digivox.repository.BookRepository;
import com.challenge.digivox.repository.ClientRepository;
import com.challenge.digivox.services.exception.ObjectNotFoundException;

public class Utils {
	
	
	@Autowired
	static BookRepository BookRepository;
	@Autowired
	static ClientRepository ClientRepository;
	
	
	
	public static Optional<Book> findBookById(Long id) {
		Optional<Book> book = BookRepository.findById(id);
		if (book ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return book;
	}
	
}
