package SetsAndMapsAdvanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer>> registry = new TreeMap<>();
        Map<String, Integer> sums = new TreeMap<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String ip = input.split("\\s+")[0];
            String user = input.split("\\s+")[1];
            int logs = Integer.parseInt(input.split("\\s+")[2]);

            registry.putIfAbsent(user, new TreeMap<>());
            sums.putIfAbsent(user, 0);
            registry.get(user).putIfAbsent(ip, 0);
            registry.get(user).put(ip, registry.get(user).get(ip) + logs);
            sums.put(user, sums.get(user) + logs);
        }

        registry.forEach((key, value) -> {
            System.out.printf("%s: %d [", key, sums.get(key));
            StringBuilder listIPs = new StringBuilder();
            value.forEach((key1, value1) -> listIPs.append(String.format("%s, ", key1)));
            listIPs.replace(listIPs.length() - 2, listIPs.length() - 1, "]");
            System.out.println(listIPs);
        });
    }
}
