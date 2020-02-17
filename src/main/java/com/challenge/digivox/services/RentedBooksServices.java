package com.challenge.digivox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.digivox.models.Book;
import com.challenge.digivox.models.RentedBook;
import com.challenge.digivox.models.enums.BookStatus;
import com.challenge.digivox.repository.BookRepository;
import com.challenge.digivox.repository.RentedBookRepository;
import com.challenge.digivox.services.exception.ObjectNotFoundException;

@Service
public class RentedBooksServices {
	
	@Autowired
	RentedBookRepository RentedBookRepository;
	
	@Autowired
	BookRepository BookRepository;
	
	public List<RentedBook> findAll(){
		return RentedBookRepository.findAll();
	}
	
	public Optional<RentedBook> findById (Long id) {
		Optional<RentedBook> rentedBook = RentedBookRepository.findById(id);
		if (rentedBook ==null) {
			throw new ObjectNotFoundException("Objeto nao encontrado!");
		}
		return rentedBook;
	}	
	
	public RentedBook save(RentedBook rentedBook) {
		Optional<Book> book =BookRepository.findById(rentedBook.getBookId());
		if(book.get().getBookStatus()==BookStatus.AVAILABLE) {
			book.get().setBookStatus(BookStatus.UNAVAILABLE);
			return RentedBookRepository.save(rentedBook);
		}
		throw new ObjectNotFoundException("objeto invalido");
		
		
	}
	
	public void delete(Long id) {
		Optional<RentedBook> rb = findById(id);
		Optional<Book> book =BookRepository.findById(rb.get().getBookId());
		book.get().setBookStatus(BookStatus.AVAILABLE);

		RentedBookRepository.deleteById(id);
	}
	
	

}
