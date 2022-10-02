package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> tempStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfPlants; i++) {
            stack.push(plants[i]);
        }

        int days = 0;

        while (true) {
            int stackSize = stack.size();

            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (stack.isEmpty()) {
                    tempStack.push(current);
                } else if (current <= stack.peek()) {
                    tempStack.push(current);
                }
            }

            if (stackSize == tempStack.size()) {
                break;
            }

            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            days++;
        }

        System.out.println(days);
    }
}
