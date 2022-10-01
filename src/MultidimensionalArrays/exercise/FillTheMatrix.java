package MultidimensionalArrays.exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int dimension = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);

        int[][] matrix = new int[dimension][dimension];
        if (type == 'A') {
            int index = 1;
            for (int col = 0; col < dimension; col++) {
                for (int row = 0; row < dimension; row++) {
                    matrix[row][col] = index++;
                }
            }
        } else if (type == 'B') {
            int index = 1;
            for (int col = 0; col < dimension; col++) {
                if (col % 2 > 0) {
                    for (int row = dimension - 1; row >= 0; row--) {
                        matrix[row][col] = index++;
                    }
                } else {
                    for (int row = 0; row < dimension; row++) {
                        matrix[row][col] = index++;
                    }
                }
            }
        }

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
