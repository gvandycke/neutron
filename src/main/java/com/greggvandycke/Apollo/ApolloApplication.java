package com.greggvandycke.Apollo;

import com.greggvandycke.Apollo.models.Movie;
import com.greggvandycke.Apollo.models.User;
import com.greggvandycke.Apollo.repositories.MovieRepository;
import com.greggvandycke.Apollo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ApolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApolloApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(MovieRepository movieRepository, UserRepository userRepository) {
		return args -> {
			Date date = new Date();

			// create user1
			User user1 = new User("Max Jones", "max123", "123", "max@gmail.com", null);
			User user2 = new User("Jim Bob", "jimmy12", "1234", "jim@yahoo.com", null);

			// save the user1
			userRepository.save(user1);
			userRepository.save(user2);

			// create three movies
			Movie movie1 = new Movie("Coco", 123);
			Movie movie2 = new Movie("1917", 135);
			Movie movie3 = new Movie("Matrix", 112);

			// save movies
			movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));

			// add movies to the user1
			user1.getMovies().addAll(Arrays.asList(movie1, movie2, movie3));
			user2.getMovies().addAll(Arrays.asList(movie1, movie3));

			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
