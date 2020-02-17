package com.challenge.digivox.resources;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.digivox.models.ReservedBook;
import com.challenge.digivox.services.ReservedBooksServices;


@RestController
@RequestMapping(value="/challenge")
public class ReservedBookResource {
	
	
	@Autowired
	ReservedBooksServices ReservedBooksServices;
	
	@CrossOrigin
	@GetMapping("/reserved_books")
	public List<ReservedBook> listReservedBooks(){
		return ReservedBooksServices.findAll();
	}
	@CrossOrigin
	@GetMapping("/reserved_book/{id}")
	public Optional<ReservedBook> listReservedBooks(@PathVariable(value="id")long id){
		return ReservedBooksServices.findById(id);
	}
	@CrossOrigin
	@PostMapping("/reserved_book")
	public ReservedBook saveReserverBook(@RequestBody ReservedBook reservedBook) {
		return ReservedBooksServices.save(reservedBook);
	}
	@CrossOrigin
	@DeleteMapping("/reserved_book/{id}")
	public void deleteReservedBooks(@PathVariable(value="id")long id){
		ReservedBooksServices.delete(id);
	}
	
	
	
	
	
	
	
	
	
}
