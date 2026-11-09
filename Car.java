// 1. Define the Class (Blueprint)
class Car {
    // Fields / Attributes (encapsulated using private)
    private String brand;
    private String model;
    private int year;
    private int speed;

    // Constructor to initialize an object
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0; // default initial speed
    }

    // Method to accelerate
    public void accelerate(int increment) {
        if (increment > 0) {
            speed += increment;
            System.out.println(brand + " accelerated by " + increment + " km/h.");
        }
    }

    // Method to brake
    public void brake(int decrement) {
        if (decrement > 0) {
            speed = Math.max(0, speed - decrement);
            System.out.println(brand + " slowed down to " + speed + " km/h.");
        }
    }

    // Method to display car information
    public void displayInfo() {
        System.out.println("Car Details: " + year + " " + brand + " " + model + 
                           " | Current Speed: " + speed + " km/h");
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }
}

// 2. Main class to create and run objects
public class Main {
    public static void main(String[] args) {
        // Creating objects (instances of the Car class)
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Tesla", "Model 3", 2024);

        // Interacting with car1
        car1.displayInfo();
        car1.accelerate(45);
        car1.brake(15);
        car1.displayInfo();

        System.out.println();

        // Interacting with car2 independently
        car2.displayInfo();
        car2.accelerate(80);
        car2.displayInfo();
    }
}
