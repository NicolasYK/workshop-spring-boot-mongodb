package com.yuzo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.workshopmongo.domain.User;
import com.yuzo.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository user_repo;
	
	
	public List<User> findAll(){
		return user_repo.findAll();
	}
}
