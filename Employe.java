// Base class (Superclass)
class Employe {
    private String name;
    private int id;
    private double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    // Method meant to be overridden by subclasses
    public double calculateTotalSalary() {
        return baseSalary;
    }

    public void displayRole() {
        System.out.println("Employee: " + name + " (ID: " + id + ")");
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

// Subclass inheriting from Employee
class Developer extends Employee {
    private double overtimePay;

    public Developer(String name, int id, double baseSalary, double overtimePay) {
        super(name, id, baseSalary); // Calls the superclass constructor
        this.overtimePay = overtimePay;
    }

    // Method Overriding (Runtime Polymorphism)
    @Override
    public double calculateTotalSalary() {
        return getBaseSalary() + overtimePay;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Software Developer");
    }
}

// Another subclass inheriting from Employee
class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Engineering Manager");
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism: Storing subclasses in an array of superclass references
        Employee[] team = {
            new Developer("Alice", 101, 75000, 5000),
            new Manager("Bob", 102, 95000, 15000),
            new Employee("Charlie", 103, 50000)
        };

        // Dynamic Method Dispatch: The correct overridden method is called at runtime
        for (Employee emp : team) {
            emp.displayRole();
            System.out.println("Total Compensation: $" + emp.calculateTotalSalary());
            System.out.println("----------------------------------------");
        }
    }
}
