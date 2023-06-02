package com.company;

import java.util.*;

public class EmployeeManager {

    private final HashMap<Integer, Employee> employees;

    public EmployeeManager(HashMap<Integer, Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz imiê:");
        String firstName = scanner.nextLine();

        System.out.println("Wpisz nazwisko:");
        String lastName = scanner.nextLine();

        System.out.println("Wpisz pozycjê:");
        String position = scanner.nextLine();

        System.out.println("Wpisz zarobki:");
        int salary = scanner.nextInt();

        int employeeID = generateUniqueEmployeeID();

        Employee employee = new Employee(firstName, lastName, position, employeeID, salary);
        employees.put(employeeID, employee);

        System.out.println("Pracownik dodany!");
    }

    private int generateUniqueEmployeeID() {
        return employees.size() + 1;
    }
    
    public void removeEmployee(Employee employee){
        if(employees.containsKey(employee.getEmployeeID()))
            employees.remove(employee.getEmployeeID());
        else
            System.out.println("Pracownik o takim ID nie istnieje");
    }

    public void updateEmployee(int employeeID, String newPosition, int newSalary) {
        if (employees.containsKey(employeeID)) {
            Employee employee = employees.get(employeeID);
            employee.setPosition(newPosition);
            employee.setSalary(newSalary);
            employees.put(employeeID, employee);
            System.out.println("Pracownik zaktualizowany!");
        } else {
            System.out.println("Pracownik o takim ID nie istnieje");
        }
    }

    public Employee searchEmployeeByID(int employeeID) {
        if(employees.containsKey(employeeID)){
            return employees.get(employeeID);
        }
        else
            System.out.println("Nie znaleziono pracownika o danym ID");
           return null;
    }
    public void listAllEmployees(){
        ArrayList<Employee> employeeList = new ArrayList<>(employees.values());
        for (Employee employee: employeeList
             ) {
            System.out.println(employee);
        }
    }

    public HashSet<Employee> searchEmployeesByLastName(String lastName) {
        HashSet<Employee> employeeList = new HashSet<>(employees.values());
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (!employee.getLastName().equals(lastName))
                employeeIterator.remove();
        }
        return employeeList;
    }

}