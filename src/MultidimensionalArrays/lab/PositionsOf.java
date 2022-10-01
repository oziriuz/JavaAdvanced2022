package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrixFromConsole(scanner);

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean foundNumber = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (numberToFind == matrix[row][col]) {
                    foundNumber = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if (!foundNumber) {
            System.out.println("not found");
        }
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
