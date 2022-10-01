package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numberToRemove = Integer.parseInt(scanner.nextLine());

        Deque<String> childrenQueue = new ArrayDeque<>();

        for (String s : input) {
            childrenQueue.offer(s);
        }
        int cycle = 1;

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < numberToRemove; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + childrenQueue.poll());
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
