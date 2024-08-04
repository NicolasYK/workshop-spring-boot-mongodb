package com.yuzo.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuzo.workshopmongo.domain.Post;
import com.yuzo.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService post_service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = post_service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
}
