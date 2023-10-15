package Lab01;
import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("HungHDG - 5062 Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("HungHDG - 5062 Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];

        System.out.println("HungHDG - 5062 Enter elements for the first matrix:");
        inputMatrixElements(matrix1, scanner);

        System.out.println("HungHDG - 5062 Enter elements for the second matrix:");
        inputMatrixElements(matrix2, scanner);

        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        System.out.println("HungHDG - 5062 Resultant Matrix after addition:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    public static void inputMatrixElements(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("HungHDG - 5062 Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Function to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return resultMatrix;
    }

    // Function to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
