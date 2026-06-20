package com.madhu.demo;

// Import Spring Boot annotations for the main application class
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Madhu Spring Boot Demo application.
 * This class bootstraps and launches the Spring Boot application.
 */
@SpringBootApplication // Enables auto-configuration, component scanning, and configuration properties
public class MadhuSpringBootDemoApplication {

    /**
     * Main method that starts the Spring Boot application.
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        // Launch the Spring Boot application
        SpringApplication.run(MadhuSpringBootDemoApplication.class, args);
    }
}
