package com.github.evgdim.jwtsec.security.model;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtPrincipal {
	private String username;
	private Claims claims;//TODO replace it with domain object
}
