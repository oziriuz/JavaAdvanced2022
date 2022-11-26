package regular_exam_advanced;

import java.util.Scanner;

public class RallyRacing {
    static int kmPassed = 0;
    static boolean isOnFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String racingCar = scanner.nextLine();
        char[][] route = getCharMatrixFromConsole(scanner, n, n);
        route[0][0] = 'C';
        int[] carPosition = {0, 0};

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (isOnFinish) {
                System.out.printf("Racing car %s finished the stage!%n", racingCar);
                break;
            }
            int carR = carPosition[0];
            int carC = carPosition[1];
            switch (command) {
                case "up":
                    carPosition = moveCar(route, carR, carC, carR - 1, carC);
                    break;
                case "down":
                    carPosition = moveCar(route, carR, carC, carR + 1, carC);
                    break;
                case "right":
                    carPosition = moveCar(route, carR, carC, carR, carC + 1);
                    break;
                case "left":
                    carPosition = moveCar(route, carR, carC, carR, carC - 1);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        if (!isOnFinish) {
            System.out.printf("Racing car %s DNF.%n", racingCar);
        }
        System.out.printf("Distance covered %d km.%n", kmPassed);
        printMatrix(route);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value);
            }
            System.out.println();
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

    private static int[] moveCar(char[][] route, int carR, int carC, int moveToR, int moveToC) {
        route[carR][carC] = '.';
        if (hasSymbol(moveToR, moveToC, route, '.')) {
            route[moveToR][moveToC] = 'C';
            kmPassed += 10;
        } else if (hasSymbol(moveToR, moveToC, route, 'T')) {
            //tunnel
            route[moveToR][moveToC] = '.';
            int[] outPosition = getSymbolCoordinates(route, 'T');
            moveToR = outPosition[0];
            moveToC = outPosition[1];
            route[moveToR][moveToC] = 'C';
            kmPassed += 30;
        } else if (hasSymbol(moveToR, moveToC, route, 'F')) {
            //finish
            kmPassed += 10;
            route[moveToR][moveToC] = 'C';
            isOnFinish = true;
        }
        return new int[]{moveToR, moveToC};
    }

    private static boolean hasSymbol(int r, int c, char[][] matrix, char symbol) {
        return matrix[r][c] == symbol;
    }

    private static int[] getSymbolCoordinates(char[][] route, char symbol) {
        for (int r = 0; r < route.length; r++) {
            for (int c = 0; c < route[0].length; c++) {
                if (route[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }
}
