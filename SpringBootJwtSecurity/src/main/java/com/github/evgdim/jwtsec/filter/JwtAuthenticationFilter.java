package com.github.evgdim.jwtsec.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.evgdim.jwtsec.model.Role;
import com.github.evgdim.jwtsec.security.model.ApplicationPrincipal;
import com.github.evgdim.jwtsec.security.utils.TokenUtils;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		String authHeader = req.getHeader("Authorization");
		if(!StringUtils.isEmpty(authHeader) && authHeader.startsWith("Bearer ")) {
			try {
				ApplicationPrincipal jwtPrincipal = TokenUtils.parseToken(authHeader);
				
				Collection<? extends GrantedAuthority> authorities = Arrays.asList(new Role("ROLE_USER"));
				Authentication authentication = new UsernamePasswordAuthenticationToken(jwtPrincipal, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authentication);			
			} catch (Exception e) {
				logger.error("Error parsing token ", e);
			}
		}
		chain.doFilter(req, resp);
	}

}
