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
import com.yuzo.workshopmongo.dto.CommentDTO;
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

		Post post1 = new Post(null, sdf.parse("04/03/2021"), "Partiu viagem", "Vou viajar para São Paulo. Abraço", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("06/03/2021"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO com1 = new CommentDTO("Boa viagem mano!", sdf.parse("05/03/2021"), new AuthorDTO(alex));
		CommentDTO com2 = new CommentDTO("Aproveite!", sdf.parse("05/03/2021"), new AuthorDTO(bob));
		CommentDTO com3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("06/03/2021"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(com1, com2));
		post2.getComments().add(com3);
		
		post_repo.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		user_repo.save(maria);
	}
}
