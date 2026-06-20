package com.madhu.demo.service;

// Import the Employee model
import com.madhu.demo.model.Employee;

// Import Spring annotation for service layer
import org.springframework.stereotype.Service;

/**
 * Service layer class for Employee-related operations.
 * Contains business logic and provides employee data to controllers.
 */
@Service // Marks this class as a Spring managed bean in the service layer
public class EmployeeService {

    /**
     * Retrieves employee details for Madhu Sudhan.
     * Returns a pre-configured Employee object with name and experience.
     * @return Employee object containing name and experience details
     */
    public Employee getEmployeeDetails() {
        // Create and return a new Employee with the predefined details
        return new Employee("Madhu Sudhan", "15 years");
    }
}
