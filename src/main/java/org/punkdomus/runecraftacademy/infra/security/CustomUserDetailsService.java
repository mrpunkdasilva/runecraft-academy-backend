package org.punkdomus.runecraftacademy.infra.security;

import org.punkdomus.runecraftacademy.infra.repository.UserRepository;
import org.punkdomus.runecraftacademy.data.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * The CustomUserDetailsService class is a Spring Security implementation of the UserDetailsService interface.
 * It is responsible for loading user-specific data when authenticating a user.
 * The class uses the UserRepository to fetch the user details by email.
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    /**
     * Loads the user details by the given username (email).
     *
     * @param username the username (email) of the user
     * @return the UserDetails object containing the user's information
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}