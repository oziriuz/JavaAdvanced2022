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
            boolean isBusyRow = true;
            for (int col = 1; col < parking[targetR].length; col++) {
                if (!parking[targetR][col]) {
                    isBusyRow = false;
                    break;
                }
            }

            if (isBusyRow) {
                System.out.printf("Row %d full%n", targetR);
            } else {
                int moves = 1;
                moves += Math.abs(entryRow - targetR);
                if (parking[targetR][targetC]) {
                    targetC = GetClosestToTarget(targetC, parking[targetR]);
                }

                moves += targetC;
                parking[targetR][targetC] = true;

                System.out.println(moves);
            }
            input = scanner.nextLine();
        }
    }

    private static int GetClosestToTarget(int targetC, boolean[] row) {
        int closestLeft = Integer.MAX_VALUE;
        int closestRight = Integer.MAX_VALUE;

        //search for the closest free on left
        for (int col = targetC - 1; col > 0; col--) {
            if (!row[col]) {
                closestLeft = col;
                break;
            }
        }

        //search for the closest free on right
        for (int col = targetC + 1; col < row.length; col++) {
            if (!row[col]) {
                closestRight = col;
                break;
            }
        }

        int distanceLeft = Math.abs(targetC - closestLeft);
        int distanceRight = Math.abs(targetC - closestRight);

        if (distanceLeft <= distanceRight) {
            return closestLeft;
        } else {
            return closestRight;
        }
    }
}
