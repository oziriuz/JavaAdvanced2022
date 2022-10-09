package multidimensional_arrays.lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = getCharMatrixFromConsole(scanner, 8, 8);
        char queen = 'q';
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == queen) {
                    if (isRealQueen(queen, row, col, board)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean isRealQueen(char queen, int row, int col, char[][] matrix) {
        //check upper-left
        int r = row;
        int c = col;
        while (r > 0 && c > 0) {
            if(matrix[--r][--c] == queen) {
                return false;
            }
        }
        //check upper-right
        r = row;
        c = col;
        while (r > 0 && c < matrix.length - 1) {
            if(matrix[--r][++c] == queen) {
                return false;
            }
        }
        //check down-left
        r = row;
        c = col;
        while (r < matrix.length - 1 && c > 0) {
            if(matrix[++r][--c] == queen) {
                return false;
            }
        }
        //check down-right
        r = row;
        c = col;
        while (r < matrix.length - 1 && c < matrix.length - 1) {
            if(matrix[++r][++c] == queen) {
                return false;
            }
        }
        //check up
        r = row;
        c = col;
        while (r > 0) {
            if(matrix[--r][c] == queen) {
                return false;
            }
        }
        //check down
        r = row;
        while (r < matrix.length - 1) {
            if(matrix[++r][c] == queen) {
                return false;
            }
        }
        //check left
        r = row;
        while (c > 0) {
            if(matrix[r][--c] == queen) {
                return false;
            }
        }
        //check right
        c = col;
        while (c < matrix.length - 1) {
            if(matrix[r][++c] == queen) {
                return false;
            }
        }
        return true;
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
}
