package com.yuzo.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.workshopmongo.domain.Post;
import com.yuzo.workshopmongo.repository.PostRepository;
import com.yuzo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository post_repo;
	
	public Post findById(String id) {
		Optional<Post> post = post_repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String  text){
		return post_repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> allSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return post_repo.allSearch(text, minDate, maxDate);
	}
}
