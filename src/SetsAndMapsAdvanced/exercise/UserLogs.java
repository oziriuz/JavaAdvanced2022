package SetsAndMapsAdvanced.exercise;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String stop = "end";

        Map<String, Map<String, Integer>> userLog = new TreeMap<>();

        while (!input.equals(stop)) {
            String stringIP = input.split("\\s+")[0];
            String stringUser = input.split("\\s+")[2];
            String ip = stringIP.split("=")[1];
            String user = stringUser.split("=")[1];

            userLog.putIfAbsent(user, new LinkedHashMap<>());
            userLog.get(user).putIfAbsent(ip, 0);
            userLog.get(user).put(ip, userLog.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userLog.entrySet()) {
            String user = entry.getKey();
            Map<String, Integer> ipMap = entry.getValue();
            System.out.println(user + ": ");
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Integer> ipKey : ipMap.entrySet()) {
                String ip = ipKey.getKey();
                int count = ipKey.getValue();
                result.append(String.format("%s => %d, ", ip, count));
            }
            result.replace(result.length() - 2, result.length(), ".");
            System.out.println(result);
        }
    }
}
