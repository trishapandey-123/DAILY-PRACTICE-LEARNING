public class LongDemo {

    public static void main(String[] args) {
        // 1. Literal declaration (requires 'L' suffix for values outside int range)
        long speedOfLightMetersPerSec = 299_792_458L;
        long worldPopulation = 8_100_000_000L; // Exceeds standard int capacity (~2.14 billion)

        System.out.println("=== Basic Values ===");
        System.out.println("Speed of Light (m/s): " + speedOfLightMetersPerSec);
        System.out.println("Estimated Population: " + worldPopulation);

        // 2. Minimum and Maximum limits
        System.out.println("\n=== Boundaries ===");
        System.out.println("Long.MIN_VALUE: " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
        System.out.println("Size in bits:   " + Long.SIZE);
        System.out.println("Size in bytes:  " + Long.BYTES);

        // 3. Overflow demonstration
        System.out.println("\n=== Overflow Behavior ===");
        long overflowExample = Long.MAX_VALUE + 1; // Wraps around to Long.MIN_VALUE
        System.out.println("Long.MAX_VALUE + 1 = " + overflowExample);

        // Safe arithmetic with exception checking (Java 8+)
        try {
            Math.addExact(Long.MAX_VALUE, 1L);
        } catch (ArithmeticException e) {
            System.out.println("Caught overflow using Math.addExact(): " + e.getMessage());
        }

        // 4. Parsing and String conversions
        System.out.println("\n=== Conversions & Parsing ===");
        String stringVal = "9876543210123";
        long parsed = Long.parseLong(stringVal);
        System.out.println("Parsed from String: " + parsed);

        long decimal = 255L;
        System.out.println("Binary:  " + Long.toBinaryString(decimal));
        System.out.println("Hex:     " + Long.toHexString(decimal).toUpperCase());
        System.out.println("Octal:   " + Long.toOctalString(decimal));

        // 5. Unsigned Long operations (Java 8+)
        System.out.println("\n=== Unsigned Operations ===");
        long unsignedMax = -1L; // Bitwise all 1s (0xFFFFFFFFFFFFFFFFL)
        System.out.println("As signed:   " + unsignedMax);
        System.out.println("As unsigned: " + Long.toUnsignedString(unsignedMax));
    }
}
