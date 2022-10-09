package sets_and_maps_advanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String stop = "stop";
        Map<String, String> mailBook = new LinkedHashMap<>();
        Set<String> domainsToReject = Set.of("us", "uk", "com");

        while (!input.equals(stop)) {
            String name = input;
            String email = scanner.nextLine();
            String mailServer = email.split("@")[1];
            String domain = mailServer.split("\\.")[1];
            if (!domainsToReject.contains(domain)) {
                mailBook.put(name, email);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : mailBook.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
