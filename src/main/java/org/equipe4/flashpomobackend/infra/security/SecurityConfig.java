package org.equipe4.flashpomobackend.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The SecurityConfig class is a Spring Security configuration class that sets up the security filters and authentication manager.
 * It configures the application to use a custom UserDetailsService implementation and a security filter.
 * The class also sets up the password encoder and the authentication manager.
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    SecurityFilter securityFilter;

    /**
     * Configures the security filter chain for the application.
     * It sets up the CSRF protection, session management, and authorization rules.
     * It also adds the custom security filter before the UsernamePasswordAuthenticationFilter.
     *
     * @param http the HttpSecurity object to configure
     * @return the SecurityFilterChain
     * @throws Exception if there is an error configuring the security filter chain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Configures the password encoder to be used for password hashing.
     *
     * @return the PasswordEncoder implementation
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the authentication manager for the application.
     *
     * @param authenticationConfiguration the AuthenticationConfiguration object
     * @return the AuthenticationManager
     * @throws Exception if there is an error configuring the authentication manager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}