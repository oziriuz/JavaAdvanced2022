package practice_exams.exam20220625;

import java.util.Scanner;

public class StickyFingers {
    static int stolenMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] town = getCharMatrixFromConsole(scanner, n, n);
        int[] playerPosition = getSymbolCoordinates(town, 'D');

        boolean isCaught = false;
        for (String command : commands) {
            int playerR = playerPosition[0];
            int playerC = playerPosition[1];
            switch (command) {
                case "up":
                    playerPosition = movePlayer(town, playerR, playerC, playerR - 1, playerC);
                    break;
                case "down":
                    playerPosition = movePlayer(town, playerR, playerC, playerR + 1, playerC);
                    break;
                case "right":
                    playerPosition = movePlayer(town, playerR, playerC, playerR, playerC + 1);
                    break;
                case "left":
                    playerPosition = movePlayer(town, playerR, playerC, playerR, playerC - 1);
                    break;
                default:
                    break;
            }

            if (playerPosition == null) {
                isCaught = true;
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                break;
            }
        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }
        printMatrix(town);
    }

    private static int[] getSymbolCoordinates(char[][] town, char symbol) {
        for (int r = 0; r < town.length; r++) {
            for (int c = 0; c < town[0].length; c++) {
                if (town[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }
        }
        return new int[2];
    }

    private static int[] movePlayer(char[][] town, int playerR, int playerC, int moveToR, int moveToC) {
        if (!isValidCoordinate(moveToR, moveToC, town)) {
            System.out.println("You cannot leave the town, there is police outside!");
        } else {
            town[playerR][playerC] = '+';
            playerR = moveToR;
            playerC = moveToC;
            if (hasSymbol(playerR, playerC, town, '$')) {
                //hasHouse
                stolenMoney += playerR * moveToC;
                System.out.printf("You successfully stole %d$.%n", moveToR * moveToC);
            } else if (hasSymbol(playerR, playerC, town, 'P')) {
                //hasPolice
                town[playerR][playerC] = '#';
                return null;
            }
            town[playerR][playerC] = 'D';
        }
        return new int[]{playerR, playerC};
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

    private static boolean isValidCoordinate(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
    }

    private static boolean hasSymbol(int r, int c, char[][] matrix, char symbol) {
        return matrix[r][c] == symbol;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
