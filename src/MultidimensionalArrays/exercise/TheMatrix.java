package MultidimensionalArrays.exercise;

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

        if (isValidCoordinate(startR, startC, matrix)) {
            char initialSymbol = matrix[startR][startC];
            matrix[startR][startC] = fillSymbol;

            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    if (matrix[row][col] == initialSymbol) {
                        if (isFillSymbolNearMe(r, c, matrix, fillSymbol, row, col)) {
                            matrix[row][col] = fillSymbol;
                        }
                    }
                }
                for (int col = c - 1; col >= 0; col--) {
                    if (matrix[row][col] == initialSymbol) {
                        if (isFillSymbolNearMe(r, c, matrix, fillSymbol, row, col)) {
                            matrix[row][col] = fillSymbol;
                        }
                    }
                }
            }

            for (int col = 0; col < c; col++) {
                for (int row = 0; row < r; row++) {
                    if (matrix[row][col] == initialSymbol) {
                        if (isFillSymbolNearMe(r, c, matrix, fillSymbol, row, col)) {
                            matrix[row][col] = fillSymbol;
                        }
                    }
                }
                for (int row = r - 1; row >= 0; row--) {
                    if (matrix[row][col] == initialSymbol) {
                        if (isFillSymbolNearMe(r, c, matrix, fillSymbol, row, col)) {
                            matrix[row][col] = fillSymbol;
                        }
                    }
                }
            }
        }

        printMatrix(matrix);
        //TODO: it is not complete solution, must use DFS or BFS
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static boolean isFillSymbolNearMe(int r, int c, char[][] matrix, char fillSymbol, int row, int col) {
        return (row < r - 1 && matrix[row + 1][col] == fillSymbol) ||
                (col < c - 1 && matrix[row][col + 1] == fillSymbol) ||
                (row > 0 && matrix[row - 1][col] == fillSymbol) ||
                (col > 0 && matrix[row][col - 1] == fillSymbol);
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
