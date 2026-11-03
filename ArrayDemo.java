public class ArrayDemo {
    public static void main(String[] args) {
        // 1. Array declaration aur initialization
        int[] numbers = {45, 12, 89, 34, 7, 65, 23};

        // 2. Array ke elements print karna
        System.out.print("Array elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // 3. Sum aur Average nikalna
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;

        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f\n", average);

        // 4. Maximum aur Minimum element dhoondhna
        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);

        // 5. Array ko reverse order me print karna
        System.out.print("Reversed Array: ");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
