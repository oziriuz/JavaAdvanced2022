package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrixFromConsole(scanner);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = coordinates[0];
        int c = coordinates[1];
        int valueToReplace = matrix[r][c];

        int[][] newMatrix = new int[matrix.length][matrix[matrix.length - 1].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (valueToReplace != matrix[row][col]) {
                    newMatrix[row][col] = matrix[row][col];
                } else {
                    int upperNumber = 0;
                    int lowerNumber = 0;
                    int leftNumber = 0;
                    int rightNumber = 0;
                    if (row > 0 && matrix[row - 1][col] != valueToReplace) {
                        upperNumber = matrix[row - 1][col];
                    }
                    if (row < matrix.length - 1 && matrix[row + 1][col] != valueToReplace) {
                        lowerNumber = matrix[row + 1][col];
                    }
                    if (col > 0 && matrix[row][col - 1] != valueToReplace) {
                        leftNumber = matrix[row][col - 1];
                    }
                    if (col < matrix[row].length - 1 && matrix[row][col + 1] != valueToReplace) {
                        rightNumber = matrix[row][col + 1];
                    }
                    newMatrix[row][col] = upperNumber + lowerNumber
                            + leftNumber + rightNumber;
                }
            }
        }

        for (int[] row : newMatrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixFromConsole(Scanner scanner) {
        int dim = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dim][];
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
}
