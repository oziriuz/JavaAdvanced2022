package SetsAndMapsAdvanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String search = "search";
        String stop = "stop";
        Map<String, String> phoneBook = new HashMap<>();

        while (!input.equals(search)) {
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            phoneBook.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals(stop)) {
            String nameToSearch = input;
            if (phoneBook.containsKey(nameToSearch)) {
                String phoneNumber = phoneBook.get(nameToSearch);
                System.out.printf("%s -> %s%n", nameToSearch, phoneNumber);
            } else {
                System.out.printf("Contact %s does not exist.%n", nameToSearch);
            }
            input = scanner.nextLine();
        }
    }
}
