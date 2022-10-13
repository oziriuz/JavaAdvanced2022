package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = dimensions[0];
        int c = dimensions[1];

        int[][] matrix = fillMatrix(r, c);

        String endString = "Nuke it from orbit";
        String input = scanner.nextLine();

        while (!input.equals(endString)) {
            String[] command = input.split("\\s+");
            int rowStartDestruction = Integer.parseInt(command[0]);
            int columnStartDestruction = Integer.parseInt(command[1]);
            int radiusOfDestruction = Integer.parseInt(command[2]);
            bombTheMatrix(matrix, rowStartDestruction, columnStartDestruction, radiusOfDestruction);
            matrix = getMatrixClean(matrix);
            input = scanner.nextLine();
        }

        printMatrixWithoutZeros(matrix);
    }

    private static int[][] getMatrixClean(int[][] oldMatrix) {

        int[][] newMatrix = new int[oldMatrix.length][oldMatrix[0].length];
        int newRow = 0;
        for (int[] row : oldMatrix) {
            int newCol = 0;
            for (int c = 0; c < oldMatrix[0].length; c++) {
                if (row[c] != 0) {
                    newMatrix[newRow][newCol++] = row[c];
                }
            }

            if (newCol > 0) {
                //move to next row only if at least one cell is filled in this one
                newRow++;
            }
        }
        return newMatrix;
    }

    private static void bombTheMatrix(int[][] matrix, int row, int col, int radius) {
        for (int i = -radius; i <= radius; i++) {
            if (isValidCoordinate(row + i, col, matrix)) {
                matrix[row + i][col] = 0;
            }

            if (isValidCoordinate(row, col + i, matrix)) {
                matrix[row][col + i] = 0;
            }
        }
    }

    private static int[][] fillMatrix(int r, int c) {
        int startNumber = 1;
        int[][] matrix = new int[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                matrix[row][col] = startNumber++;
            }
        }
        return matrix;
    }

    private static void printMatrixWithoutZeros(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isValidCoordinate(int r, int c, int[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
    }
}
