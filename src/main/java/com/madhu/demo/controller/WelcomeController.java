package com.madhu.demo.controller;

// Import Spring annotations for REST controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST controller that handles welcome-related endpoints.
 * Serves the welcome message for the Madhu Portal.
 */
@RestController // Marks this class as a REST controller (combines @Controller and @ResponseBody)
@RequestMapping("/welcome") // Base URL mapping for all endpoints in this controller
public class WelcomeController {

    /**
     * Handles GET requests to /welcome.
     * Returns a welcome message as a JSON response.
     * @return Map containing the welcome message
     */
    @GetMapping // Maps HTTP GET requests to this method
    public Map<String, String> getWelcomeMessage() {
        // Return the welcome message wrapped in a Map for JSON serialization
        return Map.of("message", "Welcome to Madhu Portal");
    }
}
