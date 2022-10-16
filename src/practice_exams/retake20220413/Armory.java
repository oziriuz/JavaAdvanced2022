package practice_exams.retake20220413;

import java.util.Scanner;

public class Armory {
    static int goldCoin = 65;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] armory = getCharMatrixFromConsole(scanner, n, n);

        int[] playerPosition = getSymbolCoordinates(armory, 'A');

        while (goldCoin > 0) {
            if (playerPosition == null) {
                break;
            }
            String command = scanner.nextLine();
            int playerR = playerPosition[0];
            int playerC = playerPosition[1];
            switch (command) {
                case "up":
                    int up = playerR - 1;
                    playerPosition = movePlayer(armory, playerR, playerC, up, playerC);
                    break;
                case "down":
                    int down = playerR + 1;
                    playerPosition = movePlayer(armory, playerR, playerC, down, playerC);
                    break;
                case "right":
                    int right = playerC + 1;
                    playerPosition = movePlayer(armory, playerR, playerC, playerR, right);
                    break;
                case "left":
                    int left = playerC - 1;
                    playerPosition = movePlayer(armory, playerR, playerC, playerR, left);
                    break;
                default:
                    break;
            }
        }

        if (goldCoin <= 0) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", 65 - goldCoin);

        printMatrix(armory);
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

    private static int[] getSymbolCoordinates(char[][] town, char symbol) {
        for (int r = 0; r < town.length; r++) {
            for (int c = 0; c < town[0].length; c++) {
                if (town[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    private static boolean isValidCoordinate(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
    }

    private static boolean hasMirror(int r, int c, char[][] matrix) {
        return matrix[r][c] == 'M';
    }

    private static boolean hasSword(int r, int c, char[][] matrix) {
        return Character.isDigit(matrix[r][c]);
    }

    private static int[] movePlayer(char[][] armory, int playerR, int playerC, int moveToR, int moveToC) {
        if (!isValidCoordinate(moveToR, moveToC, armory)) {
            armory[playerR][playerC] = '-';
            System.out.println("I do not need more swords!");
            return null;
        } else if (hasMirror(moveToR, moveToC, armory)) {
            armory[playerR][playerC] = '-';
            armory[moveToR][moveToC] = '-';
            int[] mirrorPosition = getSymbolCoordinates(armory, 'M');
            armory[mirrorPosition[0]][mirrorPosition[1]] = 'A';
            return mirrorPosition;
        } else if (hasSword(moveToR, moveToC, armory)) {
            armory[playerR][playerC] = '-';
            goldCoin -= Integer.parseInt(String.valueOf(armory[moveToR][moveToC]));
            armory[moveToR][moveToC] = 'A';
        } else {
            armory[playerR][playerC] = '-';
            armory[moveToR][moveToC] = 'A';
        }
        return new int[]{moveToR, moveToC};
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
