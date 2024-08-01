package com.yuzo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuzo.workshopmongo.domain.User;
import com.yuzo.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService user_service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = user_service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
