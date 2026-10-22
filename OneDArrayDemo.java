import java.util.Scanner;

public class OneDArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array ka size input lena
        System.out.print("Array ka size enter karein: ");
        int size = sc.nextInt();

        // 1D Array declare karna
        int[] numbers = new int[size];

        // Elements input lena
        System.out.println(size + " elements enter karein:");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        // Array ke elements print karna
        System.out.println("\nArray ke elements:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + " : " + numbers[i]);
        }

        sc.close();
    }
}
