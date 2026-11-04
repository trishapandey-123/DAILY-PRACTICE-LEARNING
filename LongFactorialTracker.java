public class LongFactorialTracker {

    public static void main(String[] args) {
        System.out.printf("%-5s %-25s %-20s%n", "n", "n! (Factorial)", "Status");
        System.out.println("-------------------------------------------------------");

        long factorial = 1L;

        for (int n = 1; n <= 22; n++) {
            // Check for potential overflow before multiplying
            if (Long.MAX_VALUE / n < factorial) {
                // n * factorial will exceed Long.MAX_VALUE
                long overflowValue = factorial * n; // Unchecked overflow wraps around
                System.out.printf("%-5d %-25d %-20s%n", n, overflowValue, "OVERFLOW! (Corrupted)");
            } else {
                factorial *= n;
                System.out.printf("%-5d %-25d %-20s%n", n, factorial, "Valid");
            }
        }
    }
}
