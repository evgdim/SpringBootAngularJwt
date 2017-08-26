package com.github.evgdim.jwtsec.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.jwtsec.model.User;
import com.github.evgdim.jwtsec.repository.UserRepository;
import com.github.evgdim.jwtsec.security.model.UserLoginVO;
import com.github.evgdim.jwtsec.security.utils.TokenUtils;

@RestController
@RequestMapping("user")
public class UserController {
	private final UserRepository userRepo;
	@Autowired	
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping
	public Principal user(Principal user) {
		return user;
	}
	
	@PostMapping("token")
	public ResponseEntity<String> generateToken(@RequestBody UserLoginVO login){
		Optional<User> user = userRepo.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		if(user.isPresent()) {
			return ResponseEntity.ok(TokenUtils.generateToken(login));			
		} else {
			return ResponseEntity.badRequest().body("Invalid credentials");
		}
	}
}
