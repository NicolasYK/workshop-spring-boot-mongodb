package com.yuzo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.yuzo.workshopmongo.domain.Post;
import com.yuzo.workshopmongo.domain.User;
import com.yuzo.workshopmongo.dto.AuthorDTO;
import com.yuzo.workshopmongo.repository.PostRepository;
import com.yuzo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository user_repo;
	
	@Autowired
	private PostRepository post_repo;
	
	@Override
	public void run(String... args) throws Exception {
		user_repo.deleteAll();
		post_repo.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		user_repo.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("04/05/2024"), "Partiu viagem", "Vou viajar para São Paulo. Abraço", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("06/03/2024"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		
		post_repo.saveAll(Arrays.asList(post1, post2));
	}
}
