package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getIntArrFromConsole(scanner);
        int r = dimensions[0];
        int c = dimensions[1];
        char[][] matrix = getCharMatrixFromConsole(scanner, r, c);
        char fillSymbol = scanner.nextLine().charAt(0);
        int[] startPosition = getIntArrFromConsole(scanner);
        int startR = startPosition[0];
        int startC = startPosition[1];
        char initialSymbol = matrix[startR][startC];

        FillMatrix(fillSymbol, initialSymbol, startR, startC, matrix);
        printMatrix(matrix);
    }

    private static void FillMatrix(char fillSymbol, char initialSymbol, int startR, int startC, char[][] matrix) {
        if (!isValidCoordinate(startR, startC, matrix) || matrix[startR][startC] != initialSymbol) {
            return;
        }

        matrix[startR][startC] = fillSymbol;

        FillMatrix(fillSymbol, initialSymbol, startR, startC + 1, matrix);
        FillMatrix(fillSymbol, initialSymbol, startR + 1, startC, matrix);
        FillMatrix(fillSymbol, initialSymbol, startR, startC - 1, matrix);
        FillMatrix(fillSymbol, initialSymbol, startR - 1, startC, matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value);
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

    private static int[] getIntArrFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isValidCoordinate(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
    }
}
