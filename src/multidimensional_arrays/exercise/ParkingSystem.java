package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        boolean[][] parking = new boolean[r][c];

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int[] data = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int entryRow = data[0];
            int targetR = data[1];
            int targetC = data[2];
            int moves = 1;

            moves += Math.abs(entryRow - targetR);

            if (parking[targetR][targetC]) {
                targetC = GetClosestToTarget(targetC, parking[targetR]);
            }

            if (targetC == 0) {
                System.out.printf("Row %d full%n", targetR);
            } else {
                moves += targetC;
                parking[targetR][targetC] = true;
                System.out.println(moves);
            }
            input = scanner.nextLine();
        }
    }

    private static int GetClosestToTarget(int targetC, boolean[] row) {
        for (int i = 1; i < row.length; i++) {
            int leftCell = targetC - i;
            int rightCell = targetC + i;

            if (leftCell > 0 && !row[leftCell]) {
                return leftCell;
            }

            if (rightCell < row.length && !row[rightCell]) {
                return rightCell;
            }
        }
        //no empty cells
        return 0;
    }
}
