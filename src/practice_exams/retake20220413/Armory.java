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
                //player left the armory
                break;
            }
            String command = scanner.nextLine();
            int playerR = playerPosition[0];
            int playerC = playerPosition[1];
            switch (command) {
                case "up":
                    playerPosition = movePlayer(armory, playerR, playerC, playerR - 1, playerC);
                    break;
                case "down":
                    playerPosition = movePlayer(armory, playerR, playerC, playerR + 1, playerC);
                    break;
                case "right":
                    playerPosition = movePlayer(armory, playerR, playerC, playerR, playerC + 1);
                    break;
                case "left":
                    playerPosition = movePlayer(armory, playerR, playerC, playerR, playerC - 1);
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

    private static boolean hasSymbol(int r, int c, char[][] matrix, char symbol) {
        return matrix[r][c] == symbol;
    }

    private static boolean hasSword(int r, int c, char[][] matrix) {
        return Character.isDigit(matrix[r][c]);
    }

    private static int[] movePlayer(char[][] armory, int playerR, int playerC, int moveToR, int moveToC) {
        armory[playerR][playerC] = '-';
        playerR = moveToR;
        playerC = moveToC;

        if (!isValidCoordinate(playerR, playerC, armory)) {
            System.out.println("I do not need more swords!");
            //leave town
            return null;
        } else {
            if (hasSword(playerR, playerC, armory)) {
                goldCoin -= Integer.parseInt(String.valueOf(armory[playerR][playerC]));
            } else if (hasSymbol(playerR, playerC, armory, 'M')) {
                //disappear from this mirror
                armory[playerR][playerC] = '-';
                //find the other mirror
                int[] mirrorPosition = getSymbolCoordinates(armory, 'M');
                assert mirrorPosition != null;
                playerR = mirrorPosition[0];
                playerC = mirrorPosition[1];
            }
        }
        armory[playerR][playerC] = 'A';
        return new int[]{playerR, playerC};
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
