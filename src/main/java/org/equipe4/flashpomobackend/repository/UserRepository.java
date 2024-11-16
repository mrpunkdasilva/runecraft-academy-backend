 package org.equipe4.flashpomobackend.repository;

import org.equipe4.flashpomobackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The UserRepository interface is a Spring Data JPA repository for the User entity.
 * It extends the JpaRepository interface, which provides basic CRUD operations.
 * The interface also includes a custom method to find a user by their email.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Finds a user by their email.
     *
     * @param email the email of the user to find
     * @return an Optional containing the user if found, or an empty Optional if not found
     */
    Optional<User> findByEmail(String email);
}