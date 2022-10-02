package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperation = Integer.parseInt(scanner.nextLine());

        StringBuilder myString = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfOperation; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            int command = Integer.parseInt(input[0]);

            switch (command) {
                case 1:
                    stack.push(myString.toString());
                    String stringToAppend = input[1];
                    myString.append(stringToAppend);
                    break;
                case 2:
                    stack.push(myString.toString());
                    int numberOfCharToDelete = Integer.parseInt(input[1]);
                    myString.delete(myString.length() - numberOfCharToDelete, myString.length());
                    break;
                case 3:
                    int indexOfCharToPrint = Integer.parseInt(input[1]) - 1;
                    char forPrinting = myString.charAt(indexOfCharToPrint);
                    System.out.println(forPrinting);
                    break;
                case 4:
                    myString = new StringBuilder(stack.pop());
                    break;
                default:
                    break;
            }
        }
    }
}
