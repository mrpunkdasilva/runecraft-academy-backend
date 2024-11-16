package org.equipe4.flashpomobackend.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.equipe4.flashpomobackend.models.User;
import org.equipe4.flashpomobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

/**
 * The SecurityFilter class is a Spring Security filter that is executed for every incoming request.
 * It is responsible for validating the JWT token and setting the authentication context for the request.
 * If the token is valid, it retrieves the user from the database and sets the authentication context accordingly.
 *
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    /**
     * Performs the filter operation for the incoming request.
     * It extracts the JWT token from the request, validates it, and sets the authentication context if the token is valid.
     *
     * @param request        the HttpServletRequest object
     * @param response       the HttpServletResponse object
     * @param filterChain    the FilterChain object
     * @throws ServletException if there is an error during the filter operation
     * @throws IOException       if there is an I/O error during the filter operation
     */@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        var login = tokenService.validateToken(token);

        if (login != null) {
            User user = userRepository.findByEmail(login).orElseThrow(() -> new RuntimeException("User Not Found"));
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Extracts the JWT token from the "Authorization" header of the request.
     *
     * @param request the HttpServletRequest object
     * @return the JWT token, or null if the header is not present
     */
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
