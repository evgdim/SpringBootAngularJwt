package com.github.evgdim.jwtsec.security.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.authentication.BadCredentialsException;

import com.github.evgdim.jwtsec.security.model.ApplicationPrincipal;
import com.github.evgdim.jwtsec.security.model.UserLoginVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public abstract class TokenUtils {
    public static final int TOKEN_VALID_FOR_MINUTES = 30;
	public static final String AUTH_HEADER = "Authorization";
    public static final String SECRET_KEY = "secretkey";

    private TokenUtils(){}

    public static ApplicationPrincipal parseToken(final String authHeader){
        final String token = authHeader.substring(7); // The part after "Bearer ";

        final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//        Integer issuedAt = (Integer) claims.get(Claims.ISSUED_AT);
//        Date expirationDate = DateUtils.addMinutes(new Date(issuedAt), TOKEN_VALID_FOR_MINUTES);
//        if(new Date().after(expirationDate)) {
//        	throw new BadCredentialsException("Token expired");
//        } 
        ApplicationPrincipal principal = new ApplicationPrincipal("todoGetFromToken", claims);
        return principal;
    }

    public static String generateToken(final UserLoginVO login){
        Date now = new Date();
        String token = Jwts.builder()
                .setSubject(login.getUsername())
                .claim("role", "USER")
                .setIssuedAt(now)
                .setExpiration(DateUtils.addMinutes(now, TOKEN_VALID_FOR_MINUTES))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }
}
