package org.punkdomus.runecraftacademy.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.punkdomus.runecraftacademy.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();

        // List of public paths that do not require authentication
        List<String> publicPaths = Arrays.asList(
            "/auth/login",
            "/auth/register"
        );

        // Check if the request path starts with any of the public paths or Swagger UI paths
        boolean isPublicPath = publicPaths.stream().anyMatch(path::startsWith) ||
                               path.startsWith("/v3/api-docs") ||
                               path.startsWith("/swagger-ui");

        if (isPublicPath) {
            filterChain.doFilter(request, response);
            return;
        }

        var token = this.recoverToken(request);
        if (token != null) {
            var email = tokenService.validateToken(token);
            if (email != null) {
                var user = userRepository.findByEmail(email).orElse(null);
                if (user != null) {
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}