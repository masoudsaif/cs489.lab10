package com.cs489.taskmanagement.utility;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cs489.taskmanagement.model.User;

import java.util.Date;

@Component
public class JwtTokenUtil {

    // The secret key used to sign and verify JWT tokens
    @Value("${jwt.secret}")
    private String secretKey;

    // The expiration time for the JWT token (in milliseconds)
    @Value("${jwt.expiration}")
    private long expiration;

    /**
     * Generates a JWT token for the specified username.
     *
     * @param username The username for which the token is to be generated.
     * @return The generated JWT token.
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    /**
     * Extracts the username from the given JWT token.
     *
     * @param token The JWT token.
     * @return The username extracted from the token.
     */
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    /**
     * Validates the given JWT token against the specified user.
     *
     * @param token The JWT token.
     * @param user The user to validate the token against.
     * @return True if the token is valid and the user matches the token; false otherwise.
     */
    public boolean validateToken(String token, User user) {
        String username = getUsernameFromToken(token);
        return username.equals(user.getEmail()) && !isTokenExpired(token);
    }

    /**
     * Checks if the given JWT token has expired.
     *
     * @param token The JWT token.
     * @return True if the token has expired; false otherwise.
     */
    private boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration().before(new Date());
    }
}
