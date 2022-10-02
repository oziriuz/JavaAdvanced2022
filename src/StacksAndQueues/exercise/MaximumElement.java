package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            int command = Integer.parseInt(input[0]);
            switch (command) {
                case 1:
                    stack.push(Integer.valueOf(input[1]));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maximum = Integer.MIN_VALUE;
                    for (Integer number : stack) {
                        maximum = Math.max(maximum, number);
                    }
                    System.out.println(maximum);
                    break;
                default:
                    break;
            }
        }
    }
}
