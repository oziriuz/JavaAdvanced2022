package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numberToRemove = Integer.parseInt(scanner.nextLine());

        Deque<String> childrenQueue = new ArrayDeque<>();

        for (String s : input) {
            childrenQueue.offer(s);
        }

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < numberToRemove; i++) {
                childrenQueue.offer(childrenQueue.poll());
            }
            System.out.println("Removed " + childrenQueue.poll());
        }

        System.out.println("Last is " + childrenQueue.poll());
    }
}
