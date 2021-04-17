package com.example.ShoeStorag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ShoeStorag.domain.Shoe;
import com.example.ShoeStorag.domain.ShoeRepository;
import com.example.ShoeStorag.domain.Type;
import com.example.ShoeStorag.domain.TypeRepository;
import com.example.ShoeStorag.domain.User;
import com.example.ShoeStorag.domain.UserRepository;

@SpringBootApplication
public class ShoeStoragApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ShoeStoragApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ShoeStoragApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ShoeRepository repository, TypeRepository trepository, UserRepository urepository) {
		return (args) -> {
			
			trepository.deleteAll();
			trepository.save(new Type("Sneaker"));
			trepository.save(new Type("Football"));
			trepository.save(new Type("Slipper"));
			trepository.save(new Type("Formal"));
			trepository.save(new Type("Running"));
			
			repository.save(new Shoe("Nike", "Air Force", "Men", "45", "119 €", trepository.findByTypename("Sneaker").get(0)));
			repository.save(new Shoe("Adidas", "Adilette Aqua Swim", "Women", "38", "20 €", trepository.findByTypename("Slipper").get(0)));
			repository.save(new Shoe("Asics", "Jolt 3", "Child", "33", "32 €", trepository.findByTypename("Running").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("get shoes");
			for (Shoe shoe : repository.findAll()) {
				log.info(shoe.toString());
			}
		};
	}
}