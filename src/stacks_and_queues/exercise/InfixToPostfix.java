package stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Set;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Deque<String> queue = new ArrayDeque<>();
        Deque<String> stack = new ArrayDeque<>();
        Set<String> specials = Set.of("*", "/", "+", "-", "(", ")");
        Set<String> addSubtract = Set.of("+", "-");
        Set<String> multiplyDivide = Set.of("*", "/");
        Set<String> brackets = Set.of("(", ")");

        for (String s : input) {
            if (!specials.contains(s)) {
                queue.offer(s);
            } else {
                if (!brackets.contains(s)) {
                    while (!stack.isEmpty() &&
                            (addSubtract.contains(s) &&
                                    (addSubtract.contains(stack.peek()) || multiplyDivide.contains(stack.peek())))) {
                        queue.offer(stack.pop());
                    }
                    while (!stack.isEmpty() && (multiplyDivide.contains(s) && multiplyDivide.contains(stack.peek()))) {
                        queue.offer(stack.pop());
                    }
                    stack.push(s);
                } else if (s.equals("(")) {
                    stack.push(s);
                } else {
                    if (!stack.isEmpty()) {
                        while (true) {
                            assert stack.peek() != null;
                            if (stack.peek().equals("(")) break;
                            queue.offer(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
