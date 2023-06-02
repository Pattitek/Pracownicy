package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Employee> employees = new HashMap<>();
        EmployeeManager employeeManager = new EmployeeManager(employees);

        // Dodawanie pracownika
        employeeManager.addEmployee();

        // Wy�wietlanie wszystkich pracownik�w
        employeeManager.listAllEmployees();

        // Wyszukiwanie pracownika po ID
        Employee searchedEmployee = employeeManager.searchEmployeeByID(1);
        if (searchedEmployee != null) {
            System.out.println("Znaleziono pracownika: " + searchedEmployee);
        } else {
            System.out.println("Nie znaleziono pracownika o podanym ID.");
        }

        // Wyszukiwanie pracownik�w po pozycji
        HashSet<Employee> employeesByPosition = employeeManager.searchEmployeesByPosition("Manager");
        System.out.println("Pracownicy na stanowisku Manager:");
        for (Employee employee : employeesByPosition) {
            System.out.println(employee);
        }

        // Usuwanie pracownika
        Employee employeeToRemove = employeeManager.searchEmployeeByID(1);
        if (employeeToRemove != null) {
            employeeManager.removeEmployee(employeeToRemove);
            System.out.println("Pracownik zosta� usuni�ty.");
        } else {
            System.out.println("Nie znaleziono pracownika o podanym ID.");
        }
    }
}