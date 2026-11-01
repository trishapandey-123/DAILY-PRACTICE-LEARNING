class Student {
    private String name;
    private int age;
    private String course;

    // 1. Default (No-Argument) Constructor
    public Student() {
        // Calls the parameterized constructor below (Constructor Chaining)
        this("Unknown", 0, "Undeclared");
        System.out.println("Default constructor called.");
    }

    // 2. Parameterized Constructor (Overload 1)
    public Student(String name, int age) {
        this(name, age, "General Studies");
    }

    // 3. Parameterized Constructor (Overload 2)
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name   : " + this.name);
        System.out.println("Age    : " + this.age);
        System.out.println("Course : " + this.course);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Invoking default constructor
        System.out.println("Creating student1:");
        Student student1 = new Student();
        student1.displayInfo();

        // Invoking 2-parameter constructor
        System.out.println("Creating student2:");
        Student student2 = new Student("Alice", 20);
        student2.displayInfo();

        // Invoking 3-parameter constructor
        System.out.println("Creating student3:");
        Student student3 = new Student("Bob", 22, "Computer Science");
        student3.displayInfo();
    }
}
