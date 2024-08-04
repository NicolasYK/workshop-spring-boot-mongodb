package com.yuzo.workshopmongo.dto;

import java.io.Serializable;

import com.yuzo.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	// Construtor
	public AuthorDTO() {}
	
	public AuthorDTO(User usr) {
		id = usr.getId();
		name = usr.getName();
	}
	
	// Get & Set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
