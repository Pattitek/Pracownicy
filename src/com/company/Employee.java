public class Employee {

    private static int nextId = 1;
    private String firstName;
    private String lastName;
    private String position;
    private int employeeID;
    private int salary;

    public Employee(String firstName, String lastName, String position, int employeeID, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeID = nextId++;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", employeeID=" + employeeID +
                ", salary=" + salary +
                '}';
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }
}
