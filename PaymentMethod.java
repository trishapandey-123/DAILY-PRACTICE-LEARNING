// ==============================================================
// 1. ABSTRACTION (Interface & Abstract Class)
// ==============================================================

// Interface defining a contract for any payment gateway
interface PaymentMethod {
    void processPayment(double amount);
}

// Abstract base class for all catalog items
abstract class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = Math.max(price, 0.0);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method: physical and digital items calculate delivery differently
    abstract void deliver();
}

// ==============================================================
// 2. INHERITANCE
// ==============================================================

class PhysicalProduct extends Item {
    private double weightKg;

    public PhysicalProduct(String name, double price, double weightKg) {
        super(name, price);
        this.weightKg = weightKg;
    }

    @Override
    void deliver() {
        System.out.println("Shipping '" + getName() + "' (" + weightKg + "kg) via courier.");
    }
}

class DigitalProduct extends Item {
    private String downloadLink;

    public DigitalProduct(String name, double price, String downloadLink) {
        super(name, price);
        this.downloadLink = downloadLink;
    }

    @Override
    void deliver() {
        System.out.println("Emailed download link for '" + getName() + "': " + downloadLink);
    }
}

// ==============================================================
// 3. POLYMORPHISM (Interface Implementations)
// ==============================================================

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        String masked = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Charged $" + amount + " to Credit Card (" + masked + ")");
    }
}

class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " via UPI ID: " + upiId);
    }
}

// ==============================================================
// 4. ENCAPSULATION
// ==============================================================

class ShoppingCart {
    private java.util.List<Item> cartItems; // Hidden internal state

    public ShoppingCart() {
        this.cartItems = new java.util.ArrayList<>();
    }

    public void addItem(Item item) {
        cartItems.add(item);
        System.out.println("Added: " + item.getName() + " ($" + item.getPrice() + ")");
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

    // Polymorphism in action: accepts ANY payment implementation
    public void checkout(PaymentMethod paymentMethod) {
        double total = calculateTotal();
        if (total <= 0) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n--- Processing Checkout ---");
        paymentMethod.processPayment(total);

        System.out.println("--- Fulfilling Delivery ---");
        for (Item item : cartItems) {
            item.deliver(); // Runtime dispatch based on actual object type
        }
        cartItems.clear();
        System.out.println("Order completed successfully!\n");
    }
}

// ==============================================================
// EXECUTION
// ==============================================================

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding different subclasses of Item
        cart.addItem(new PhysicalProduct("Mechanical Keyboard", 89.99, 1.1));
        cart.addItem(new DigitalProduct("Java Masterclass eBook", 19.99, "https://downloads.example.com/java-book"));

        // Polymorphic payment: Swap between UPI, Credit Card, etc., without altering cart logic
        PaymentMethod payment = new UPIPayment("developer@okhdfcbank");
        cart.checkout(payment);
    }
}
