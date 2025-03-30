package com.sms.employee;

import com.sms.model.Employee;        
import com.sms.service.EmployeeService;  
import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        try {
            // Create instance of EmployeeService
            EmployeeService employeeService = new EmployeeService();

            // Add sample data
            System.out.println("Loading employee data...");
            employeeService.addSampleData();

            // Display all employees
            System.out.println("\nAll Employees:");
            System.out.println("------------------------");
            employeeService.getAllEmployees()
                          .forEach(System.out::println);

            // Display concatenated name and department
            System.out.println("\nEmployee Name - Department:");
            System.out.println("------------------------");
            List<String> employeeInfo = employeeService.getEmployeeNameAndDepartment();
            employeeInfo.forEach(System.out::println);

            // Display average salary
            System.out.println("\nAverage Salary:");
            System.out.println("------------------------");
            double averageSalary = employeeService.calculateAverageSalary();
            System.out.printf("$%.2f%n", averageSalary);

            // Filter and display employees above age 30
            System.out.println("\nEmployees above 30 years:");
            System.out.println("------------------------");
            List<Employee> seniorEmployees = employeeService.filterByAge(30);
            seniorEmployees.forEach(System.out::println);

            // Display Function interface explanation
            System.out.println("\nFunction Interface Explanation:");
            System.out.println("------------------------");
            System.out.println("The Function interface in Java:");
            System.out.println("1. Is  a functional interface from java.util.function package");
            System.out.println("2. function that accepts one argument and produces a result");
            System.out.println("3. Contains a single abstract method apply(T t)");
            System.out.println("4. Used to transform Employee objects into formatted strings");
            System.out.println("5. Enables functional programming and lambda expressions in Java");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}