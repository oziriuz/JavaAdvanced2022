package StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Deque<Integer> numbers = new ArrayDeque<>();

        for (String s : input) {
            numbers.push(Integer.valueOf(s));
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
