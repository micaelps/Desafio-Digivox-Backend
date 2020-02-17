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
import com.challenge.digivox.models.RentedBook;
import com.challenge.digivox.services.RentedBooksServices;


@RestController
@RequestMapping(value="/challenge")
public class RentedBookResource {
	
	
	@Autowired
	RentedBooksServices RentedBooksServices;
	
	@CrossOrigin
	@GetMapping("/rented_books")
	public List<RentedBook> listRentedBooks(){
		return RentedBooksServices.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/rented_book/{id}")
	public Optional<RentedBook> listRentedBooks(@PathVariable(value="id")long id){
		return RentedBooksServices.findById(id);
	}
	
	@CrossOrigin
	@PostMapping("/rented_book")
	public RentedBook saveRentedBook(@RequestBody RentedBook rentedBook) {
		return RentedBooksServices.save(rentedBook);
	}
	
	@CrossOrigin
	@DeleteMapping("/rented_book/{id}")
	public void deleteRentedBooks(@PathVariable(value="id")long id){
		RentedBooksServices.delete(id);
	}
	
	
	
	
	
	
	
	
	
}
