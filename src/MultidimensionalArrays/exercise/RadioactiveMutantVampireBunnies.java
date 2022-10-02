package MultidimensionalArrays.exercise;

import java.util.*;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        int numberOfStrings = r;
        char[][] lair = new char[r][c];
        int row = 0;

        while (numberOfStrings-- > 0) {
            char[] input = scanner.nextLine().toCharArray();
            System.arraycopy(input, 0, lair[row], 0, input.length);
            row++;
        }

        char[] command = scanner.nextLine().toCharArray();
        int[] currentPlace = getPlayerCoordinates(lair);
        int currentR = currentPlace[0];
        int currentC = currentPlace[1];
        boolean isDead = false;
        boolean hasWon = false;

        for (char way : command) {
            int lastR = currentR;
            int lastC = currentC;
            currentPlace = PlayerMove(way, lair, currentR, currentC);
            currentR = currentPlace[0];
            currentC = currentPlace[1];

            if (!isInLair(currentR, currentC, lair)) {
                hasWon = true;
            } else {
                //check if player is dead after moving
                if (lair[currentR][currentC] == 'D') {
                    lair[currentR][currentC] = 'B';
                    isDead = true;
                }
            }
            SpreadBunnies(lair);
            //check if player is dead after the spread
            if (isInLair(currentR, currentC, lair) && lair[currentR][currentC] != 'P') {
                isDead = true;
            }

            if (isDead) {
                printLair(lair);
                System.out.printf("dead: %d %d%n", currentR, currentC);
                break;
            }

            if (hasWon) {
                printLair(lair);
                System.out.printf("won: %d %d%n", lastR, lastC);
                break;
            }
        }
    }

    private static void SpreadBunnies(char[][] lair) {
        //find all cells with bunnies
        Deque<String> bunniesQueue = new ArrayDeque<>();
        for (int r = 0; r < lair.length; r++) {
            for (int c = 0; c < lair[r].length; c++) {
                if (lair[r][c] == 'B') {
                    bunniesQueue.offer(r + "-" + c);
                }
            }
        }
        //get one by one and spread
        while (!bunniesQueue.isEmpty()) {
            int[] position = Arrays.stream(bunniesQueue.poll().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = position[0];
            int col = position[1];

            //spread up and down
            for (int r = row - 1; r <= row + 1; r++) {
                if (isInLair(r, col, lair)) {
                    lair[r][col] = 'B';
                }
            }
            //spread left and right
            for (int c = col - 1; c <= col + 1; c++) {
                if (isInLair(row, c, lair)) {
                    lair[row][c] = 'B';
                }
            }
        }
    }

    private static int[] PlayerMove(char direction, char[][] lair, int currentR, int currentC) {
        int oldR = currentR;
        int oldC = currentC;
        switch (direction) {
            case 'L':
                currentC--;
                break;
            case 'R':
                currentC++;
                break;
            case 'U':
                currentR--;
                break;
            case 'D':
                currentR++;
                break;
            default:
                break;
        }

        int[] newPos = new int[]{currentR, currentC};
        if (!isInLair(currentR, currentC, lair)) {
            lair[oldR][oldC] = '.';
            return newPos;
        }
        if (HasBunny(currentR, currentC, lair)) {
            lair[currentR][currentC] = 'D';
            return newPos;
        }
        lair[oldR][oldC] = '.';
        lair[currentR][currentC] = 'P';
        return newPos;
    }

    private static boolean isInLair(int r, int c, char[][] lair) {
        return r >= 0 && r < lair.length && c >= 0 && c < lair[lair.length - 1].length;
    }

    private static boolean HasBunny(int currentR, int currentC, char[][] lair) {
        return lair[currentR][currentC] == 'B';
    }

    private static int[] getPlayerCoordinates(char[][] lair) {
        int[] result = new int[]{-1, -1};
        for (int r = 0; r < lair.length; r++) {
            for (int c = 0; c < lair[r].length; c++) {
                if (lair[r][c] == 'P') {
                    result[0] = r;
                    result[1] = c;
                }
            }
        }

        return result;
    }

    private static void printLair(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
