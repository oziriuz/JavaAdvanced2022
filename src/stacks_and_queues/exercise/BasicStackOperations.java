package stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);

        input = scanner.nextLine().split("\\s+");

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.push(Integer.valueOf(input[i]));
        }

        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        int smallest = Integer.MAX_VALUE;

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(X)) {
            System.out.println("true");
        } else {
            while (!stack.isEmpty()) {
                smallest = Math.min(smallest, stack.pop());
            }
            System.out.println(smallest);
        }
    }
}
