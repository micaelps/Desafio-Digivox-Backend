package com.challenge.digivox.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.digivox.models.Book;
import com.challenge.digivox.services.BookServices;

@RestController
@RequestMapping(value="/challenge")
public class BookResource {
	
	
	@Autowired
	BookServices BookServices;
	
	@CrossOrigin
	@GetMapping("/books")
	public List<Book> listBooks(){
		return BookServices.findAll();
	}
	@CrossOrigin
	@GetMapping("/book/{id}")
	public Optional<Book> listBooks(@PathVariable(value="id")long id){
		return BookServices.findById(id);
	}
	@CrossOrigin
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book) {
		return BookServices.save(book);
	}
	@CrossOrigin
	@DeleteMapping("/book/{id}")
	public void deleteBooks(@PathVariable(value="id")long id){
		BookServices.delete(id);
	}
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book book) {
		return BookServices.save(book);
	}
	
	
	@GetMapping("/books_avaliables")
	public List<Book> listBooksAvailables(){
		return BookServices.availableBooks();
	}
	
	@GetMapping("/books_unavaliables")
	public List<Book> listBooksUnavailables(){
		return BookServices.unavailableBooks();
	}
	
}
