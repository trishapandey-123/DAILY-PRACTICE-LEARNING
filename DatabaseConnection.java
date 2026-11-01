// Implementing AutoCloseable acts as the modern destructor pattern in Java
class DatabaseConnection implements AutoCloseable {
    private String connectionName;

    // Constructor: Acquires the resource
    public DatabaseConnection(String connectionName) {
        this.connectionName = connectionName;
        System.out.println("[Constructor] Connection '" + connectionName + "' opened.");
    }

    public void executeQuery(String query) {
        System.out.println("Executing query on " + connectionName + ": " + query);
    }

    // "Destructor" equivalent: Releases the resource
    @Override
    public void close() {
        System.out.println("[Destructor/Close] Connection '" + connectionName + "' closed.");
    }
}

public class DestructorExample {
    public static void main(String[] args) {
        System.out.println("Entering try-with-resources block...");

        // The resource is created here
        try (DatabaseConnection db = new DatabaseConnection("ProductionDB")) {
            db.executeQuery("SELECT * FROM users");
        } // db.close() is automatically called right here when leaving scope

        System.out.println("Exited try-with-resources block.");
    }
}
