package com.challenge.digivox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.digivox.models.Book;
import com.challenge.digivox.models.ReservedBook;
import com.challenge.digivox.models.enums.BookStatus;
import com.challenge.digivox.repository.BookRepository;
import com.challenge.digivox.repository.ReservedBookRepository;
import com.challenge.digivox.services.exception.ObjectNotFoundException;

@Service
public class ReservedBooksServices {
	
	@Autowired
	ReservedBookRepository ReservedBookRepository;
	
	@Autowired
	BookRepository BookRepository;
	
	//this.book.setBookStatus(BookStatus.UNAVAILABLE);
	
	public List<ReservedBook> findAll(){
		return ReservedBookRepository.findAll();
	}
	
	public Optional<ReservedBook> findById (Long id) {
		Optional<ReservedBook> reservedBook = ReservedBookRepository.findById(id);
		if (reservedBook ==null) {
			throw new ObjectNotFoundException("Objeto nao encontrado!");
		}
		return reservedBook;
	}	
	
	public ReservedBook save(ReservedBook reservedBook) {
		Optional<Book> book =BookRepository.findById(reservedBook.getBookId());
		if(book.get().getBookStatus()==BookStatus.AVAILABLE) {
			book.get().setBookStatus(BookStatus.UNAVAILABLE);
			return ReservedBookRepository.save(reservedBook);
		}
		throw new ObjectNotFoundException("objeto invalido");
		
		
	}
	
	public void delete(Long id) {
		Optional<ReservedBook> rb = findById(id);
		Optional<Book> book =BookRepository.findById(rb.get().getBookId());
		book.get().setBookStatus(BookStatus.AVAILABLE);

		ReservedBookRepository.deleteById(id);
	}
	
	

}
