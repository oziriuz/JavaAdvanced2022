package SetsAndMapsAdvanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new TreeMap<>() {{
            put("fragments", 0);
            put("shards", 0);
            put("motes", 0);
        }};

        Map<String, Integer> junks = new TreeMap<>();

        boolean isWon = false;
        while (!isWon) {
            String[] inputData = scanner.nextLine().split("\\s+");

            for (int i = 0; i < inputData.length; i += 2) {
                Integer quantity = Integer.parseInt(inputData[i]);
                String item = inputData[i + 1].toLowerCase();

                if (items.containsKey(item)) {
                    items.put(item, items.get(item) + quantity);
                } else {
                    junks.putIfAbsent(item, 0);
                    junks.put(item, junks.get(item) + quantity);
                }

                if (items.get("shards") >= 250) {
                    isWon = true;
                    items.put("shards", items.get("shards") - 250);
                    System.out.println("Shadowmourne obtained!");
                    break;
                } else if (items.get("fragments") >= 250) {
                    isWon = true;
                    items.put("fragments", items.get("fragments") - 250);
                    System.out.println("Valanyr obtained!");
                    break;
                } else if (items.get("motes") >= 250) {
                    isWon = true;
                    items.put("motes", items.get("motes") - 250);
                    System.out.println("Dragonwrath obtained!");
                    break;
                }
            }
        }

        items.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));

        junks.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
