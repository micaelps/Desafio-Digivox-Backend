package com.challenge.digivox.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_RESERVED_BOOK")

public class ReservedBook implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Long clientId;
	
	private Long bookId;

	private String date;
	
	

	public ReservedBook(Long clientId, Long bookId, String date) {
		this.date = date;
		this.clientId = clientId;
		this.bookId = bookId;
	}


	public ReservedBook() {
		
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	

	public Long getBookId() {
		return bookId;
	}

	
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

	
	
	
	
	
}
