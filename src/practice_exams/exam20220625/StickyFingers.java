package practice_exams.exam20220625;

import java.util.Scanner;

public class StickyFingers {
    static int stolenMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] town = getCharMatrixFromConsole(scanner, n, n);
        int[] playerPosition = getPlayerCoordinates(town);

        for (String command : commands) {
            assert playerPosition != null;
            int playerR = playerPosition[0];
            int playerC = playerPosition[1];
            switch (command) {
                case "up":
                    int up = playerR - 1;
                    playerPosition = movePlayer(town, playerR, playerC, up, playerC);
                    break;
                case "down":
                    int down = playerR + 1;
                    playerPosition = movePlayer(town, playerR, playerC, down, playerC);
                    break;
                case "right":
                    int right = playerC + 1;
                    playerPosition = movePlayer(town, playerR, playerC, playerR, right);
                    break;
                case "left":
                    int left = playerC - 1;
                    playerPosition = movePlayer(town, playerR, playerC, playerR, left);
                    break;
                default:
                    break;
            }

            if (playerPosition == null) {
                printMatrix(town);
                return;
            }
        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        printMatrix(town);
    }

    private static int[] getPlayerCoordinates(char[][] town) {
        for (int r = 0; r < town.length; r++) {
            for (int c = 0; c < town[0].length; c++) {
                if (town[r][c] == 'D') {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    private static int[] movePlayer(char[][] town, int playerR, int playerC, int moveToR, int moveToC) {
        if (!isValidCoordinate(moveToR, moveToC, town)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return new int[]{playerR, playerC};
        } else if (hasPolice(moveToR, moveToC, town)) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
            town[playerR][playerC] = '+';
            town[moveToR][moveToC] = '#';
            return null;
        } else if (hasHouse(moveToR, moveToC, town)) {
            town[playerR][playerC] = '+';
            town[moveToR][moveToC] = 'D';
            System.out.printf("You successfully stole %d$.%n", moveToR * moveToC);
            stolenMoney += moveToR * moveToC;
        } else {
            town[playerR][playerC] = '+';
            town[moveToR][moveToC] = 'D';
        }
        return new int[]{moveToR, moveToC};
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

    private static boolean hasPolice(int r, int c, char[][] matrix) {
        return matrix[r][c] == 'P';
    }

    private static boolean hasHouse(int r, int c, char[][] matrix) {
        return matrix[r][c] == '$';
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
