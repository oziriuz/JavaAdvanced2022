package sets_and_maps_advanced.exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String stop = "JOKER";
        Map<String, Set<String>> peopleWithCards = new LinkedHashMap<>();

        while (!input.equals(stop)) {
            String name = input.split(": ")[0];
            String cardsInput = input.split(": ")[1];
            String[] cards = cardsInput.split(", ");
            Set<String> cardsSet = new HashSet<>(List.of(cards));
            peopleWithCards.putIfAbsent(name, cardsSet);
            if (peopleWithCards.containsKey(name)) {
                cardsSet = peopleWithCards.get(name);
                cardsSet.addAll(List.of(cards));
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> cardValues = new HashMap<>() {
            {
                put("2", 2);
                put("3", 3);
                put("4", 4);
                put("5", 5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("J", 11);
                put("Q", 12);
                put("K", 13);
                put("A", 14);
            }
        };

        Map<Character, Integer> colorValue = new HashMap<>() {
            {
                put('S', 4);
                put('H', 3);
                put('D', 2);
                put('C', 1);
            }
        };

        for (Map.Entry<String, Set<String>> entry : peopleWithCards.entrySet()) {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int sumOfPoints = 0;
            for (String card : cards) {
                String cardValue = card.substring(0, card.length() - 1);
                char color = card.charAt(card.length() - 1);
                sumOfPoints += cardValues.get(cardValue) * colorValue.get(color);
            }

            System.out.printf("%s: %d%n", name, sumOfPoints);
        }
    }
}
