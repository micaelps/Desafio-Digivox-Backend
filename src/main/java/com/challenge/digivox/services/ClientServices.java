package com.challenge.digivox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.digivox.models.Client;
import com.challenge.digivox.repository.ClientRepository;
import com.challenge.digivox.services.exception.ObjectNotFoundException;

@Service
public class ClientServices {
	
	
	@Autowired
	ClientRepository ClientRepository;
	
	
	
	public List<Client> findAll(){
		return ClientRepository.findAll();
	}

	public Optional<Client> findById(Long id) {
		Optional<Client> client = ClientRepository.findById(id);
		if (client ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return client;
	}
	
	public Client save(Client client) {
		return ClientRepository.save(client);
	}
	
	public void delete(Long id) {
		findById(id);
		ClientRepository.deleteById(id);
	}
	
	
	
}
