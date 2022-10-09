package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = getMatrixFromConsole(scanner);

        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            if (input[0].equals("swap") && input.length == 5) {
                int r1 = Integer.parseInt(input[1]);
                int c1 = Integer.parseInt(input[2]);
                int r2 = Integer.parseInt(input[3]);
                int c2 = Integer.parseInt(input[4]);
                if (isValidCoordinate(r1, c1, matrix) && isValidCoordinate(r2, c2, matrix)) {
                    String temp = matrix[r1][c1];
                    matrix[r1][c1] = matrix[r2][c2];
                    matrix[r2][c2] = temp;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCoordinate(int r, int c, String[][] matrix) {
        return r >= 0 && r <= matrix.length - 1 && c >= 0 && c <= matrix[matrix.length - 1].length - 1;
    }

    private static String[][] getMatrixFromConsole(Scanner scanner) {
        int[] dimensions = getIntArrFromConsole(scanner);
        int r = dimensions[0];
        int c = dimensions[1];
        String[][] matrix = new String[r][c];
        for (int row = 0; row < r; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
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
