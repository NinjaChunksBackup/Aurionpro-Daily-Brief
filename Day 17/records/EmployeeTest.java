import java.util.*;

public class EmployeeTest {
    public static void main(String[] args) {
        // Create list of employees
        List<Employee> employees = List.of(
            new Employee("Mayuri", 70000, "HR"),
            new Employee("Om", 40000, "Finance"),
            new Employee("Riya", 55000, "HR"),
            new Employee("Rohan", 30000, "IT"),
            new Employee("Sneha", 90000, "Finance")
        );

        // 🔹 Print all employees
        System.out.println("All Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // 🔹 Filter only HR department
        System.out.println("\nHR Department:");
        employees.stream()
            .filter(e -> e.department().equals("HR"))
            .forEach(e -> System.out.println(e.getDetails()));

        // 🔹 Sort by salary descending
        System.out.println("\nSorted by Salary (High to Low):");
        employees.stream()
            .sorted((e1, e2) -> Double.compare(e2.salary(), e1.salary()))
            .forEach(e -> System.out.println(e.getDetails()));

        // 🔹 High salary employees
        System.out.println("\nEmployees with High Salary:");
        employees.stream()
            .filter(Employee::isHighSalary)
            .forEach(e -> System.out.println(e.getDetails()));
    }
}
