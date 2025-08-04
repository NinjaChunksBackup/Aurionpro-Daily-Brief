public record Employee(String name, double salary, String department) {

    public String getDetails() {
        return name + " | " + department + " | ₹" + salary;
    }

    
    public boolean isHighSalary() {
        return salary > 50000;
    }
}
