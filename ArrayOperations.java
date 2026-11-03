import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // 1. Element Search karna (Linear Search)
        int target = 22;
        int foundIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break; // Element mil gaya, loop roko
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element " + target + " Index " + foundIndex + " par mila.");
        } else {
            System.out.println("Element " + target + " array me nahi mila.");
        }

        // 2. Array ko Sort karna (Bubble Sort)
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 3. Sorted array print karna
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(arr));

        // 4. Second Largest element nikalna (Sorting ke baad second last element)
        int secondLargest = arr[n - 2];
        System.out.println("Second Largest Element: " + secondLargest);
    }
}
