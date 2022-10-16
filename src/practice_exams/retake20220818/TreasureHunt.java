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

        int playerR = 0;
        int playerC = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (treasureMap[i][j] == 'Y') {
                    playerR = i;
                    playerC = j;
                    break;
                }
            }
        }

        int treasureR = 0;
        int treasureC = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (treasureMap[i][j] == 'X') {
                    treasureR = i;
                    treasureC = j;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals(end)) {
            switch (command) {
                case "up":
                    int up = playerR - 1;
                    if (isValidCoordinate(up, playerC, treasureMap) && !hasTree(up, playerC, treasureMap)) {
                        playerR = up;
                        path.add("up");
                    }
                    break;
                case "down":
                    int down = playerR + 1;
                    if (isValidCoordinate(down, playerC, treasureMap) && !hasTree(down, playerC, treasureMap)) {
                        playerR = down;
                        path.add("down");
                    }
                    break;
                case "right":
                    int right = playerC + 1;
                    if (isValidCoordinate(playerR, right, treasureMap) && !hasTree(playerR, right, treasureMap)) {
                        playerC = right;
                        path.add("right");
                    }
                    break;
                case "left":
                    int left = playerC - 1;
                    if (isValidCoordinate(playerR, left, treasureMap) && !hasTree(playerR, left, treasureMap)) {
                        playerC = left;
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

    private static boolean hasTree(int r, int c, char[][] matrix) {
        return matrix[r][c] == 'T';
    }
}
