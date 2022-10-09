package multidimensional_arrays.exercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageOnTurn = Double.parseDouble(scanner.nextLine());

        double healthHeigan = 3_000_000;
        int healthPlayer = 18_500;
        int cloudDamage = 3_500;
        int eruptionDamage = 6_000;
        String cloud = "Cloud";
        String diedFromSpell = "";

        //place a player in the middle
        int playerRow = 7;
        int playerCol = 7;
        boolean hasCloud = false;

        while (healthHeigan > 0 && healthPlayer > 0) {
            healthHeigan -= damageOnTurn;

            if (hasCloud) {
                healthPlayer -= cloudDamage;
                hasCloud = false;
                if (healthPlayer < 0) {
                    break;
                }
            }

            if (healthHeigan < 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int spellRow = Integer.parseInt(input[1]);
            int spellColumn = Integer.parseInt(input[2]);

            boolean[][] chamber = new boolean[15][15];
            ActivateSpell(chamber, spellRow, spellColumn);

            if (isDamageCell(playerRow, playerCol, chamber)) {
                //move player if in damage zone
                int[] newPlayerPosition = TryMovePlayerToSafePlace(chamber, playerRow, playerCol);
                playerRow = newPlayerPosition[0];
                playerCol = newPlayerPosition[1];
            }

            if (isDamageCell(playerRow, playerCol, chamber)) {
                int spellDamage;
                if (spell.equals(cloud)) {
                    hasCloud = true;
                    spellDamage = cloudDamage;
                    diedFromSpell = "Plague Cloud";
                } else {
                    spellDamage = eruptionDamage;
                    diedFromSpell = "Eruption";
                }
                healthPlayer -= spellDamage;
            }
        }

        if (healthHeigan > 0) {
            System.out.printf("Heigan: %.2f%n", healthHeigan);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (healthPlayer > 0) {
            System.out.printf("Player: %d%n", healthPlayer);
        } else {
            System.out.println("Player: Killed by " + diedFromSpell);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static void ActivateSpell(boolean[][] chamber, int row, int col) {
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (isValidCoordinate(r, c, chamber)) {
                    chamber[r][c] = true;
                }
            }
        }
    }

    private static int[] TryMovePlayerToSafePlace(boolean[][] chamber, int posR, int posC) {
        int[] posNew = new int[]{posR, posC};
        //look up
        int checkR = posR - 1;
        int checkC = posC;
        if (isValidCoordinate(checkR, checkC, chamber) && !isDamageCell(checkR, checkC, chamber)) {
            //move up
            posNew[0] = checkR;
            return posNew;
        }

        //look right
        checkR = posR;
        checkC = posC + 1;
        if (isValidCoordinate(checkR, checkC, chamber) && !isDamageCell(checkR, checkC, chamber)) {
            //move right
            posNew[1] = checkC;
            return posNew;
        }

        //look down
        checkR = posR + 1;
        checkC = posC;
        if (isValidCoordinate(checkR, checkC, chamber) && !isDamageCell(checkR, checkC, chamber)) {
            //move down
            posNew[0] = checkR;
            return posNew;
        }

        //look left
        checkR = posR;
        checkC = posC - 1;
        if (isValidCoordinate(checkR, checkC, chamber) && !isDamageCell(checkR, checkC, chamber)) {
            //move left
            posNew[1] = checkC;
            return posNew;
        }
        return posNew;
    }

    private static boolean isDamageCell(int r, int c, boolean[][] chamber) {
        return chamber[r][c];
    }

    private static boolean isValidCoordinate(int r, int c, boolean[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[matrix.length - 1].length;
    }
}
