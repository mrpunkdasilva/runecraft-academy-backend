package org.equipe4.flashpomobackend.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The CorsConfig class is a Spring MVC configuration class that sets up the CORS (Cross-Origin Resource Sharing) policy for the application.
 * It allows requests from the specified origin and allows the GET, POST, DELETE, and PUT HTTP methods.
 *
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configures the CORS policy for the application.
     *
     * @param registry the CorsRegistry object to configure the CORS policy
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "DELETE", "PUT");
    }
}