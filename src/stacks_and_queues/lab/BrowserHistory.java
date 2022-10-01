package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> history = new ArrayDeque<>();
        String currentPage = null;

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    System.out.println(history.pop());
                }
            } else {
                if (currentPage != null) {
                    history.push(currentPage);
                }
                currentPage = input;
                System.out.println(currentPage);
            }
            input = scanner.nextLine();
        }
    }
}
