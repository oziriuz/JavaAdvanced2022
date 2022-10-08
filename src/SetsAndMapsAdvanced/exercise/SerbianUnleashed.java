package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String stop = "End";

        Map<String, Map<String, Integer>> places = new LinkedHashMap<>();

        while (!input.equals(stop)) {

            String regex = "^([a-zA-Z]+ ?[a-zA-Z]* ?[a-zA-Z]*) @([a-zA-Z]+ ?[a-zA-Z]* ?[a-zA-Z]*) (\\d+) (\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            String singer;
            String place;
            int ticketPrice;
            int numberOfTickets;

            if (matcher.find()) {
                singer = matcher.group(1);
                place = matcher.group(2);
                ticketPrice = Integer.parseInt(matcher.group(3));
                numberOfTickets = Integer.parseInt(matcher.group(4));
            } else {
                input = scanner.nextLine();
                continue;
            }

            int money = numberOfTickets * ticketPrice;

            places.putIfAbsent(place, new LinkedHashMap<>());
            places.get(place).putIfAbsent(singer, 0);
            places.get(place).put(singer, places.get(place).get(singer) + money);

            input = scanner.nextLine();
        }

        places.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
