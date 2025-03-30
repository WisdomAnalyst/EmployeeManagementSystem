package com.sms.service;

import com.sms.model.Employee;  
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeService {
    private List<Employee> employees;

    // Constructor
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    // Method to add sample employee data
    public void addSampleData() {
        employees.add(new Employee("Wisdom Akano", 32, "IT", 75000));
        employees.add(new Employee("Diosayya Agosa", 28, "HR", 65000));
        employees.add(new Employee("Jordy Sharpe", 42, "Finance", 85000));
        employees.add(new Employee("Ubaid Ahmed", 35, "Marketing", 70000));
        employees.add(new Employee("Abiodun Abolade", 25, "IT", 62000));
    }

    // Method to add a single employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to get concatenated name and department using Function interface
    public List<String> getEmployeeNameAndDepartment() {
        Function<Employee, String> nameAndDepartment = 
            employee -> employee.getName() + " - " + employee.getDepartment();

        return employees.stream()
                       .map(nameAndDepartment)
                       .collect(Collectors.toList());
    }

    // Method to calculate average salary
    public double calculateAverageSalary() {
        return employees.stream()
                       .mapToDouble(Employee::getSalary)
                       .average()
                       .orElse(0.0);
    }

    // Method to filter employees above age threshold
    public List<Employee> filterByAge(int ageThreshold) {
        return employees.stream()
                       .filter(emp -> emp.getAge() > ageThreshold)
                       .collect(Collectors.toList());
    }

    // Method to get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}