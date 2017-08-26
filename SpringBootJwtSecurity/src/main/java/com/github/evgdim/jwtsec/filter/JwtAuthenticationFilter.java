package com.github.evgdim.jwtsec.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.evgdim.jwtsec.security.model.JwtPrincipal;
import com.github.evgdim.jwtsec.security.model.Role;
import com.github.evgdim.jwtsec.security.utils.TokenUtils;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		String authHeader = req.getHeader("Authorization");
		if(!StringUtils.isEmpty(authHeader) && authHeader.startsWith("Bearer ")) {
			//TODO check
			try {
				JwtPrincipal jwtPrincipal = TokenUtils.parseToken(authHeader);
				//TODO validate expired
				Collection<? extends GrantedAuthority> authorities = Arrays.asList(new Role("ROLE_USER"));
				Authentication authentication = new UsernamePasswordAuthenticationToken(jwtPrincipal, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authentication);			
			} catch (Exception e) {
				// TODO: log
			}
		}
		chain.doFilter(req, resp);
	}

}
