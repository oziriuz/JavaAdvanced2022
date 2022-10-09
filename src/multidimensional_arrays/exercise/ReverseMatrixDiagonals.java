package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrixFromConsole(scanner);

        int currentR = matrix.length - 1;
        int currentC = matrix[currentR].length - 1;

        while (currentR >= 0 && currentC >= 0) {
            int r = currentR;
            int c = currentC;
            while (isInMatrix(r, c, matrix)) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            if (currentC > 0) {
                currentC--;
            } else {
                currentR--;
            }
        }
    }

    private static boolean isInMatrix(int r, int c, int[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
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
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
