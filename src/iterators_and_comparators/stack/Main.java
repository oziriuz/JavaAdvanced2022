package iterators_and_comparators.stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String end = "END";

        Stack<Integer> stack = new Stack<>();

        while (!input[0].equals(end)) {
            switch (input[0]) {
                case "Push":
                    Integer[] temp = new Integer[input.length - 1];
                    for (int i = 1; i < input.length; i++) {
                        String tempInt = input[i].replace(",", "");
                        temp[i - 1] = Integer.parseInt(tempInt);
                    }
                    stack.add(temp);
                    break;
                case "Pop":
                    if(stack.pop() == null) {
                        System.out.println("No elements");
                    }
                    break;
                default:
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        for (Object element : stack) {
            System.out.println(element);
        }

        for (Object element : stack) {
            System.out.println(element);
        }
    }
}
