package MultidimensionalArrays.exercise;

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
            matrixDestruction(matrix, rowStartDestruction, columnStartDestruction, radiusOfDestruction);
            matrix = clearDestructedCells(matrix);
            input = scanner.nextLine();
        }

        printMatrixWithoutZeros(matrix);
    }

    private static int[][] clearDestructedCells(int[][] oldMatrix) {
        int rows = oldMatrix.length;
        int columns = oldMatrix[rows - 1].length;

        int[][] newMatrix = new int[rows][columns];
        int newRow = 0;
        for (int[] row : oldMatrix) {
            int newCol = 0;
            for (int c = 0; c < columns; c++) {
                if (row[c] != 0) {
                    newMatrix[newRow][newCol++] = row[c];
                }
            }

            //move to next row only if at least one cell is filled in this one
            if (newCol > 0) {
                newRow++;
            }
        }
        return newMatrix;
    }

    private static void matrixDestruction(int[][] matrix, int row, int col, int radius) {
        //bomb up and down
        for (int bombR = row - radius; bombR <= row + radius; bombR++) {
            if (isValidCoordinate(bombR, col, matrix)) {
                matrix[bombR][col] = 0;
            }
        }
        //bomb left and right
        for (int bombC = col - radius; bombC <= col + radius; bombC++) {
            if (isValidCoordinate(row, bombC, matrix)) {
                matrix[row][bombC] = 0;
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
