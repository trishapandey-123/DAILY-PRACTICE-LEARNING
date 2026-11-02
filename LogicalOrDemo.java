public class LogicalOrDemo {
    public static void main(String[] args) {
        int age = 17;
        boolean hasGuardianConsent = true;

        // Either condition being true satisfies the check
        if (age >= 18 || hasGuardianConsent) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }

        // Short-circuit demonstration
        int x = 5;
        // (x > 0) is true, so ++x is NEVER executed
        if (x > 0 || ++x > 10) {
            System.out.println("Short-circuit bypassed right-hand side. x is still: " + x);
        }
    }
}
