package stacks_and_queues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Set;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        Set<Character> openingBrackets = Set.of('(', '{','[');
        Set<Character> closingBrackets = Set.of(')', '}',']');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : input) {
            if(openingBrackets.contains(ch)) {
                stack.push(ch);
            }
            if (closingBrackets.contains(ch)) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                switch (ch) {
                    case ')':
                        if (stack.pop() != '(') {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            System.out.println("NO");
                            return;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("YES");
    }
}
