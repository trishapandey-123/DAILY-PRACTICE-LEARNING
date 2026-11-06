import java.util.ArrayList;
import java.util.List;

// ==============================================================
// 1. ABSTRACTION
// ==============================================================
// Defines the contract for all employee types without dictating salary calculations.
abstract class Employee {
    // Encapsulated fields
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Abstract methods: Subclasses must define their own payment and role logic
    public abstract double calculateSalary();
    public abstract String getRole();

    public void displaySummary() {
        System.out.printf("[%s] ID: %d | Name: %-12s | Payout: $%.2f%n", 
            getRole(), id, name, calculateSalary());
    }
}

// ==============================================================
// 2. INHERITANCE
// ==============================================================
// SalariedEmployee inherits from Employee and handles fixed monthly wages.
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;

    public FullTimeEmployee(int id, String name, double monthlySalary, double bonus) {
        super(id, name);
        this.monthlySalary = Math.max(0, monthlySalary);
        this.bonus = Math.max(0, bonus);
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }

    @Override
    public String getRole() {
        return "Full-Time";
    }
}

// Contractor inherits from Employee and calculates pay based on hours worked.
class Contractor extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = Math.max(0, hourlyRate);
        this.hoursWorked = Math.max(0, hoursWorked);
    }

    @Override
    public double calculateSalary() {
        // Standard hours + 1.5x overtime for hours above 40
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked;
        }
        int overtimeHours = hoursWorked - 40;
        return (40 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
    }

    @Override
    public String getRole() {
        return "Contractor";
    }
}

// CommissionEmployee inherits from Employee and calculates earnings by sales volume.
class CommissionEmployee extends Employee {
    private double baseSalary;
    private double totalSales;
    private double commissionRate; // e.g., 0.10 for 10%

    public CommissionEmployee(int id, String name, double baseSalary, double totalSales, double commissionRate) {
        super(id, name);
        this.baseSalary = Math.max(0, baseSalary);
        this.totalSales = Math.max(0, totalSales);
        this.commissionRate = Math.max(0, commissionRate);
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (totalSales * commissionRate);
    }

    @Override
    public String getRole() {
        return "Sales Rep ";
    }
}

// ==============================================================
// 3. ENCAPSULATION & POLYMORPHISM
// ==============================================================
// PayrollManager maintains internal state and processes all Employee variations uniformly.
class PayrollManager {
    // Encapsulation: internal list hidden from direct outside mutation
    private final List<Employee> staffList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        staffList.add(emp);
    }

    // Polymorphism: Treats all concrete instances as base Employee references
    public void runPayroll() {
        System.out.println("========== MONTHLY PAYROLL REPORT ==========");
        double totalExpense = 0.0;

        for (Employee emp : staffList) {
            // Dynamic dispatch: calls the appropriate calculateSalary() at runtime
            emp.displaySummary();
            totalExpense += emp.calculateSalary();
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Total Company Payroll Expense: $%.2f%n", totalExpense);
        System.out.println("============================================\n");
    }
}

// ==============================================================
// EXECUTION
// ==============================================================
public class Main {
    public static void main(String[] args) {
        PayrollManager payroll = new PayrollManager();

        // Registering various employee types
        payroll.addEmployee(new FullTimeEmployee(101, "Alice Chen", 5500.00, 750.00));
        payroll.addEmployee(new Contractor(102, "Bob Miller", 45.00, 48)); // 40 hrs regular + 8 hrs overtime
        payroll.addEmployee(new CommissionEmployee(103, "Carla Ortiz", 2000.00, 35000.00, 0.08));

        // Execute unified payroll computation
        payroll.runPayroll();
    }
}
