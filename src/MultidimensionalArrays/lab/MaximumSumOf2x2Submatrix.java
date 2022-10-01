package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrixFromConsole(scanner);

        int maximum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = 0;
                sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maximum) {
                    maximum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        for (int row = maxRow; row <= maxRow + 1; row++) {
            for (int col = maxCol; col <= maxCol + 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maximum);
    }

    private static int[][] getMatrixFromConsole(Scanner scanner) {
        int[] dimensions = getIntArrFromConsole(scanner);
        int r = dimensions[0];
        int c = dimensions[1];
        int[][] matrix = new int[r][c];
        for (int row = 0; row < r; row++) {
            int[] arr = getIntArrFromConsole(scanner);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] getIntArrFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
