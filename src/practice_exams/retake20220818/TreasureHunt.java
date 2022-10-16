package practice_exams.retake20220818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getIntArrFromConsole(scanner);
        int r = dimensions[0];
        int c = dimensions[1];
        char[][] treasureMap = getCharMatrixFromConsole(scanner, r, c);
        String end = "Finish";

        List<String> path = new ArrayList<>();

        int[] player = getSymbolCoordinates(treasureMap, 'Y');
        int playerR = player[0];
        int playerC = player[1];

        int[] treasure = getSymbolCoordinates(treasureMap, 'X');
        int treasureR = treasure[0];
        int treasureC = treasure[1];

        String command = scanner.nextLine();
        while (!command.equals(end)) {
            switch (command) {
                case "up":
                    if (isValidCoordinate(playerR - 1, playerC, treasureMap)
                            && !hasSymbol(playerR - 1, playerC, treasureMap, 'T')) {
                        playerR--;
                        path.add("up");
                    }
                    break;
                case "down":
                    if (isValidCoordinate(playerR + 1, playerC, treasureMap)
                            && !hasSymbol(playerR + 1, playerC, treasureMap, 'T')) {
                        playerR++;
                        path.add("down");
                    }
                    break;
                case "right":
                    if (isValidCoordinate(playerR, playerC + 1, treasureMap)
                            && !hasSymbol(playerR, playerC + 1, treasureMap, 'T')) {
                        playerC++;
                        path.add("right");
                    }
                    break;
                case "left":
                    if (isValidCoordinate(playerR, playerC - 1, treasureMap) && !hasSymbol(playerR, playerC - 1, treasureMap, 'T')) {
                        playerC--;
                        path.add("left");
                    }
                default:
                    break;
            }

            command = scanner.nextLine();
        }

        if (playerR == treasureR && playerC == treasureC) {
            System.out.println("I've found the treasure!");
            String rightPath = String.join(", ", path);
            System.out.printf("The right path is %s", rightPath);
        } else {
            System.out.println("The map is fake!");
        }
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

    private static int[] getIntArrFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isValidCoordinate(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
    }

    private static boolean hasSymbol(int r, int c, char[][] matrix, char symbol) {
        return matrix[r][c] == symbol;
    }

    private static int[] getSymbolCoordinates(char[][] matrix, char symbol) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }
        }
        return new int[2];
    }
}
