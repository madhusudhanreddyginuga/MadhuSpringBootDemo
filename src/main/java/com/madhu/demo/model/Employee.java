package com.madhu.demo.model;

/**
 * Model class representing an Employee entity.
 * Contains employee name and years of experience.
 */
public class Employee {

    // Full name of the employee
    private String name;

    // Total years of professional experience
    private String experience;

    /**
     * Default constructor required for JSON serialization/deserialization.
     */
    public Employee() {
    }

    /**
     * Parameterized constructor to create an Employee with given details.
     * @param name the full name of the employee
     * @param experience the years of experience as a string
     */
    public Employee(String name, String experience) {
        this.name = name;
        this.experience = experience;
    }

    /**
     * Returns the name of the employee.
     * @return employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     * @param name employee name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the years of experience of the employee.
     * @return experience years as a string
     */
    public String getExperience() {
        return experience;
    }

    /**
     * Sets the years of experience of the employee.
     * @param experience experience years to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }
}
