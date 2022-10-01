package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrixFromConsole(scanner);
        int firstDiagonal = getSumDiagonal(matrix, 0, 0);
        int secondDiagonal = getSumDiagonal(matrix, matrix.length - 1, 0);

        int diagonalDifference = firstDiagonal - secondDiagonal;
        System.out.println(Math.abs(diagonalDifference));
    }

    private static int[][] getMatrixFromConsole(Scanner scanner) {
        int dim = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dim][dim];
        for (int row = 0; row < dim; row++) {
            int[] arr = getIntArrFromConsole(scanner);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] getIntArrFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int getSumDiagonal(int[][] matrix, int startRow, int startColumn) {
        int result = 0;
        int r = startRow;
        int c = startColumn;
        int pos = 0;
        if (startRow == 0 && startColumn == 0) {
            while (r < matrix.length && c < matrix.length) {
                result += matrix[r++][c++];
            }
        } else if (startRow == matrix.length - 1 && startColumn == 0) {
            while (r >= 0 && c < matrix.length) {
                result += matrix[r--][c++];
            }
        } else if (startRow == 0 && startColumn == matrix[matrix.length - 1].length - 1) {
            while (r < matrix.length && c >= 0) {
                result += matrix[r++][c--];
            }
        } else if (startRow == matrix.length - 1 && startColumn == matrix[matrix.length - 1].length - 1) {
            while (r >= 0 && c >= 0) {
                result += matrix[r--][c--];
            }
        }
        return result;
    }
}
