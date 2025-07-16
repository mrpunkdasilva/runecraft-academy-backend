package org.punkdomus.runecraftacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The FlashpomoBackendApplication class is the entry point for the Flashpomo Backend application.
 * It is a Spring Boot application that uses the @SpringBootApplication annotation to configure the application.
 *
 * @author Your Name
 */
@SpringBootApplication
public class RunecraftAcademyBackendApplication {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RunecraftAcademyBackendApplication.class, args);
    }
}