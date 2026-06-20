package com.madhu.demo.controller;

// Import the Employee model and service
import com.madhu.demo.model.Employee;
import com.madhu.demo.service.EmployeeService;

// Import Spring annotations for REST controller and dependency injection
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that handles employee-related endpoints.
 * Provides employee information via RESTful APIs.
 */
@RestController // Marks this class as a REST controller
@RequestMapping("/experience") // Base URL mapping for all endpoints in this controller
public class EmployeeController {

    // Inject the EmployeeService dependency
    @Autowired // Spring automatically injects the EmployeeService bean
    private EmployeeService employeeService;

    /**
     * Handles GET requests to /experience.
     * Returns employee details (name and experience) as a JSON response.
     * @return Employee object serialized as JSON
     */
    @GetMapping // Maps HTTP GET requests to this method
    public Employee getEmployeeExperience() {
        // Delegate to the service layer to fetch employee details
        return employeeService.getEmployeeDetails();
    }
}
