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
import com.challenge.digivox.models.Client;
import com.challenge.digivox.services.ClientServices;

@RestController
@RequestMapping(value="/challenge")
public class ClientResource {
	
	
	@Autowired
	ClientServices ClientServices;
	
	@CrossOrigin(origins = "*", allowedHeaders="*")
	@GetMapping("/clients")
	public List<Client> listClients(){
		return ClientServices.findAll();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders="*")
	@GetMapping("/client/{id}")
	public Optional<Client> listClients(@PathVariable(value="id")long id){
		return ClientServices.findById(id);
	}
	@CrossOrigin(origins = "*", allowedHeaders="*")
	@PostMapping("/client")
	public Client saveClient(@RequestBody Client book) {
		return ClientServices.save(book);
		
	}			
	
	@CrossOrigin(origins = "*", allowedHeaders="*")
	@DeleteMapping("/client/{id}")
	public void deleteBooks(@PathVariable(value="id")long id){
		ClientServices.delete(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders="*")
	@PutMapping("/client")
	public Client updateBook(@RequestBody Client client) {
		return ClientServices.save(client);
	}
	
	
}
