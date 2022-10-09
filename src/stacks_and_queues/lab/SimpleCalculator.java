package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+": stack.push(String.valueOf(first + second));
                    break;
                case "-": stack.push(String.valueOf(first - second));
                    break;
                default:
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}
