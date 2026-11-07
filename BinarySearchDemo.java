public class BinarySearchDemo {

    // 1. Iterative Binary Search
    // Time Complexity: O(log n), Space Complexity: O(1)
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Avoid potential integer overflow compared to (low + high) / 2
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found, return index
            } else if (arr[mid] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found
    }

    // 2. Recursive Binary Search
    // Time Complexity: O(log n), Space Complexity: O(log n) due to call stack
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: Target not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, high);
        } else {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        // Test Iterative
        int resultIterative = binarySearchIterative(sortedArray, target);
        System.out.println("Iterative Search: Element found at index: " + resultIterative);

        // Test Recursive
        int resultRecursive = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
        System.out.println("Recursive Search: Element found at index: " + resultRecursive);

        // Test Element Not Found
        int notFound = binarySearchIterative(sortedArray, 50);
        System.out.println("Searching for 50: " + (notFound == -1 ? "Not found" : "Found at " + notFound));
    }
}
