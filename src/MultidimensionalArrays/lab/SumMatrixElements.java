package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrixFromConsole(scanner);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sumOfElements = sumOfMatrixElements(matrix);
        System.out.println(sumOfElements);
    }

    private static int sumOfMatrixElements(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
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
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
