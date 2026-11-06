// ==========================================
// 1. ABSTRACTION
// ==========================================
// Abstract class cannot be instantiated directly; it defines a template.
abstract class Vehicle {
    private String brand; // Encapsulated field

    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract method: sub-classes MUST provide an implementation
    abstract void startEngine();

    // Concrete method: shared functionality
    public String getBrand() {
        return brand;
    }
}

// ==========================================
// 2. ENCAPSULATION
// ==========================================
// Hiding internal data using private fields and providing controlled access.
class BankAccount {
    private double balance; // Data hidden from direct external modification

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Controlled setter / business logic
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

// ==========================================
// 3. INHERITANCE
// ==========================================
// Car inherits attributes and methods from Vehicle using 'extends'.
class Car extends Vehicle {
    private int doors;

    public Car(String brand, int doors) {
        super(brand); // Calls the constructor of the parent class (Vehicle)
        this.doors = doors;
    }

    // Fulfilling the abstract contract from Vehicle
    @Override
    void startEngine() {
        System.out.println(getBrand() + " engine starts with a push-button ignition.");
    }

    public void displayDetails() {
        System.out.println(getBrand() + " has " + doors + " doors.");
    }
}

// ==========================================
// 4. POLYMORPHISM
// ==========================================
// Sub-class demonstrating dynamic method overriding.
class Motorcycle extends Vehicle {
    public Motorcycle(String brand) {
        super(brand);
    }

    // Runtime Polymorphism (Method Overriding)
    @Override
    void startEngine() {
        System.out.println(getBrand() + " engine roars with a kick-starter.");
    }

    // Compile-time Polymorphism (Method Overloading)
    public void rev() {
        System.out.println(getBrand() + ": Vroom!");
    }

    public void rev(int times) {
        System.out.print(getBrand() + ": ");
        for (int i = 0; i < times; i++) {
            System.out.print("Vroom! ");
        }
        System.out.println();
    }
}

// ==========================================
// MAIN EXECUTION CLASS
// ==========================================
public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. Abstraction & Inheritance ===");
        Car myCar = new Car("Toyota", 4);
        myCar.displayDetails();
        myCar.startEngine();

        System.out.println("\n=== 2. Polymorphism ===");
        // Upcasting: Vehicle reference points to Car and Motorcycle objects
        Vehicle v1 = new Car("Honda", 2);
        Vehicle v2 = new Motorcycle("Harley-Davidson");

        // Runtime polymorphism (calls respective overridden startEngine methods)
        v1.startEngine();
        v2.startEngine();

        // Method overloading demonstration
        Motorcycle bike = new Motorcycle("Yamaha");
        bike.rev();
        bike.rev(3);

        System.out.println("\n=== 3. Encapsulation ===");
        BankAccount account = new BankAccount(500.0);
        System.out.println("Initial Balance: $" + account.getBalance());
        account.deposit(250.0);
        System.out.println("Updated Balance: $" + account.getBalance());
    }
}
