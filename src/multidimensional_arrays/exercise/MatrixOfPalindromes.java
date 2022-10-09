package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = dimensions[0];
        int c = dimensions[1];

        String[][] matrix = new String[r][c];

        char middleLetter = 'a';
        char outerLetter = 'a';
        for (int row = 0; row < r; row++) {
            char mid = middleLetter;
            for (int col = 0; col < c; col++) {
                matrix[row][col] = String.format("%c%c%c", outerLetter, mid, outerLetter);
                mid++;
            }
            middleLetter++;
            outerLetter++;
        }
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
