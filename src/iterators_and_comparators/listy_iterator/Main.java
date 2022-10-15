package iterators_and_comparators.listy_iterator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String end = "END";

        ListyIterator listy = new ListyIterator();

        while (!input[0].equals(end)) {
            switch (input[0]) {
                case "Create":
                    listy = new ListyIterator(Arrays.copyOfRange(input, 1, input.length));
                    break;
                case "HasNext":
                    System.out.println(listy.hasNext());
                    break;
                case "Move":
                    System.out.println(listy.move());
                    break;
                case "Print":
                    try {
                        listy.print();
                    } catch (NoSuchElementException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "PrintAll":
                    listy.printAll();
                    break;
                default:
                    break;
            }

            input = scanner.nextLine().split(" ");
        }
    }
}
