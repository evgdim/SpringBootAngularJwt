package com.github.evgdim.jwtsec.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginVO {
	private String username;
	private String password;
}
