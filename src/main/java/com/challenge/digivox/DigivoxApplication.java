package com.challenge.digivox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@SpringBootApplication
public class DigivoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigivoxApplication.class, args);
	}

}
