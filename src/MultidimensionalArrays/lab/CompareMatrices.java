package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = getMatrixFromConsole(scanner);
        int[][] secondMatrix = getMatrixFromConsole(scanner);

        if(matricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
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
