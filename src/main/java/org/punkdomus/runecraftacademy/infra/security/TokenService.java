package org.punkdomus.runecraftacademy.infra.security;

import com.auth0.jwt.JWT;
import org.punkdomus.runecraftacademy.data.models.User;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * The TokenService class is responsible for generating and validating JWT tokens for user authentication.
 * It uses the HMAC256 algorithm with a secret key to sign and verify the tokens.
 * The tokens are set to expire after 2 hours.
 *
 */
@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    /**
     * Generates a JWT token for the given user.
     *
     * @param user the user for whom the token is generated
     * @return the generated JWT token
     * @throws RuntimeException if there is an error while creating the token
     */
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("flashpomo-backend")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExperirationDate())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("ERROR WHILE AUTHENTICATING");
        }
    }

    /**
     * Validates the given JWT token.
     *
     * @param token the JWT token to be validated
     * @return the email of the user associated with the token, or null if the token is invalid
     */
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("flashpomo-backend")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    /**
     * Generates the expiration date for the JWT token, which is 2 hours from the current time.
     *
     * @return the Instant representing the expiration date
     */
    private Instant generateExperirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}