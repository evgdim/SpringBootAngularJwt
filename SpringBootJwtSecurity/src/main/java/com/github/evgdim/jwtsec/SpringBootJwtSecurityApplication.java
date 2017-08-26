package com.github.evgdim.jwtsec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.evgdim.jwtsec.model.User;
import com.github.evgdim.jwtsec.repository.UserRepository;

@SpringBootApplication
public class SpringBootJwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtSecurityApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner exec(UserRepository userRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				User user = new User();
				user.setUsername("evgeni");
				user.setPassword("evgeni");
				userRepo.save(user);
			}
		};
	}
}
