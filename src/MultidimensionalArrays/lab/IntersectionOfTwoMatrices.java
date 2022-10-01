package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = getCharMatrixFromConsole(scanner, r, c);
        char[][] secondMatrix = getCharMatrixFromConsole(scanner, r, c);

        char[][] intersectionMatrix = new char[r][c];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    intersectionMatrix[row][col] = firstMatrix[row][col];
                } else {
                    intersectionMatrix[row][col] = '*';
                }
            }
        }

        printMatrix(intersectionMatrix);
    }

    private static void printMatrix(char[][] intersectionMatrix) {
        for (char[] row : intersectionMatrix) {
            for (char value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static char[][] getCharMatrixFromConsole(Scanner scanner, int r, int c) {
        char[][] matrix = new char[r][c];
        for (int row = 0; row < r; row++) {
            String input = scanner.nextLine().replace(" ", "");
            char[] arr = input.toCharArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
