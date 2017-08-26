package com.github.evgdim.jwtsec.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.jwtsec.security.model.UserLoginVO;
import com.github.evgdim.jwtsec.security.utils.TokenUtils;

@RestController
@RequestMapping("user")
public class UserController {
	@GetMapping
	public Principal user(Principal user) {
		return user;
	}
	
	@PostMapping("token")
	public String generateToken(@RequestBody UserLoginVO login){
		//TODO check username pass
		return TokenUtils.generateToken(login);
	}
}
