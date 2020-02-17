package com.challenge.digivox.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.digivox.models.Book;
import com.challenge.digivox.models.enums.BookStatus;
import com.challenge.digivox.repository.BookRepository;
import com.challenge.digivox.services.exception.ObjectNotFoundException;

@Service	
public class BookServices {
	
	@Autowired
	BookRepository BookRepository;
	
	
	public List<Book> findAll(){
		return BookRepository.findAll();
	}

	public Optional<Book> findById(Long id) {
		Optional<Book> book = BookRepository.findById(id);
		if (book ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return book;
	}
	
	public Book save(Book book) {
		return BookRepository.save(book);
	}
	
	public void delete(Long id) {
		findById(id);
		BookRepository.deleteById(id);
	}
	
	public List<Book> availableBooks() {
		List<Book> list = new ArrayList<Book>();
		for(Book book : BookRepository.findAll()) {
			if(book.getBookStatus()==BookStatus.AVAILABLE) {
				list.add(book);
			}
		}
		return list;
	}
	
	public List<Book> unavailableBooks() {
		List<Book> list = new ArrayList<Book>();
		for(Book book : BookRepository.findAll()) {
			if(book.getBookStatus()!=BookStatus.AVAILABLE) {
				list.add(book);
			}
		}
		return list;
	}
	
	
	
}
