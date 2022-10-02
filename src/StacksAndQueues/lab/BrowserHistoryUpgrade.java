package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> history = new ArrayDeque<>();
        Deque<String> historyForward = new ArrayDeque<>();
        String currentPage = null;

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    historyForward.push(currentPage);
                    currentPage = history.pop();
                    System.out.println(currentPage);
                }
            } else if (input.equals("forward")) {
                if (historyForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    history.push(currentPage);
                    currentPage = historyForward.pop();
                    System.out.println(currentPage);
                }
            } else {
                if (currentPage != null) {
                    history.push(currentPage);
                }
                currentPage = input;
                System.out.println(currentPage);
                historyForward.clear();
            }
            input = scanner.nextLine();
        }
    }
}
