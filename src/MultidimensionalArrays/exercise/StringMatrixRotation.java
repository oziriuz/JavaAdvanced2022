package MultidimensionalArrays.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotationDegrees = Integer.parseInt(scanner.nextLine().split("[()]")[1]);
        String input = scanner.nextLine();

        Deque<String> wordQueue = new ArrayDeque<>();
        int columns = 0;
        int rows = 0;
        while (!input.equals("END")) {
            columns = Math.max(columns, input.length());
            wordQueue.offer(input);
            rows++;
            input = scanner.nextLine();
        }

        char[][] matrix = new char[rows][columns];
        int r = 0;
        while (!wordQueue.isEmpty() || r > rows) {
            char[] temp = Objects.requireNonNull(wordQueue.poll()).toCharArray();
            System.arraycopy(temp, 0, matrix[r], 0, temp.length);
            for (int c = temp.length; c < columns; c++) {
                matrix[r][c] = ' ';
            }
            r++;
        }

        if (rotationDegrees >= 360) {
            rotationDegrees -= 360;
        }
        int numberOfRotations = rotationDegrees / 90;

        for (int i = 0; i < numberOfRotations; i++) {
            matrix = rotateMatrix(matrix);
        }
        printMatrix(matrix);
    }

    private static char[][] rotateMatrix(char[][] oldMatrix) {
        int oldRows = oldMatrix.length;
        int newRows = oldMatrix[oldRows - 1].length;
        char[][] newMatrix = new char[newRows][oldRows];

        for (int r = 0; r < newRows; r++) {
            int rowInOld = oldRows;
            for (int c = 0; c < oldRows; c++) {
                newMatrix[r][c] = oldMatrix[--rowInOld][r];
            }
        }
        return newMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
