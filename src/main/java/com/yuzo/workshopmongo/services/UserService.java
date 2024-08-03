package com.yuzo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.workshopmongo.domain.User;
import com.yuzo.workshopmongo.repository.UserRepository;
import com.yuzo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository user_repo;
	
	
	public List<User> findAll(){
		return user_repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = user_repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	
}
