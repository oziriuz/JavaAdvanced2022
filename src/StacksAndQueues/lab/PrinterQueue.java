package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    System.out.println("Canceled " + printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }

            input = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
