import java.util.Scanner;

public class TwoDArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rows aur columns ka size input lena
        System.out.print("Rows ki sankhya dalein: ");
        int rows = sc.nextInt();
        System.out.print("Columns ki sankhya dalein: ");
        int cols = sc.nextInt();

        // 2D Array declare karna
        int[][] matrix = new int[rows][cols];

        // Elements input lena
        System.out.println("Elements enter karein (" + (rows * cols) + " values):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Matrix format mein display karna
        System.out.println("\n2D Array (Matrix):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
