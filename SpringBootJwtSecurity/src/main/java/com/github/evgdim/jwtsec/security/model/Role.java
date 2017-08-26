package com.github.evgdim.jwtsec.security.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authority;
	@Override
	public String getAuthority() {
		return authority;
	}

}
