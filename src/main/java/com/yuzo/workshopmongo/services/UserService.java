package com.yuzo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.workshopmongo.domain.User;
import com.yuzo.workshopmongo.dto.UserDTO;
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
	
	public User insert(User usr) {
		return user_repo.insert(usr);
	}
	
	public void delete(String id) {
		if (findById(id) != null) {
			user_repo.deleteById(id);
		}
	}
	
	public User update(User usr) {
		Optional<User> newUser = user_repo.findById(usr.getId());
		User user = newUser.get();
		updateData(user, usr);
		return user_repo.save(user);
	}

	private void updateData(User user, User usr) {
		user.setName(usr.getName());
		user.setName(usr.getEmail());
	}

	public User fromDTO(UserDTO usrDTO) {
		return new User(usrDTO.getId(), usrDTO.getName(), usrDTO.getEmail());
	}
	
	
}
