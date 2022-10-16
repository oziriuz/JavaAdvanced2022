package practice_exams.retake20220413;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Deque<Integer> steelQueue = new ArrayDeque<>();
        for (String s : input) {
            steelQueue.offer(Integer.parseInt(s));
        }

        input = scanner.nextLine().split(" ");
        Deque<Integer> carbonStack = new ArrayDeque<>();
        for (String s : input) {
            carbonStack.push(Integer.parseInt(s));
        }

        Map<Integer, String> recipes = new HashMap<>();
        recipes.put(70, "Gladius");
        recipes.put(80, "Shamshir");
        recipes.put(90, "Katana");
        recipes.put(110, "Sabre");

        Map<String, Integer> readySwords = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int mix = steel + carbon;

            if (recipes.containsKey(mix)) {
                readySwords.putIfAbsent(recipes.get(mix), 0);
                readySwords.put(recipes.get(mix), readySwords.get(recipes.get(mix)) + 1);
            } else {
                carbon += 5;
                carbonStack.push(carbon);
            }
        }

        int totalSwords = 0;
        for (Integer value : readySwords.values()) {
            totalSwords += value;
        }

        if (readySwords.size() > 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        System.out.print("Steel left: ");
        if (steelQueue.isEmpty()) {
            System.out.print("none");
        } else {
            while (!steelQueue.isEmpty()) {
                System.out.print(steelQueue.poll());
                if (!steelQueue.isEmpty()) {
                    System.out.println(", ");
                }
            }
        }
        System.out.println();

        System.out.print("Carbon left: ");
        if (carbonStack.isEmpty()) {
            System.out.print("none");
        } else {
            while (!carbonStack.isEmpty()) {
                System.out.print(carbonStack.pop());
                if (!carbonStack.isEmpty()) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();

        for (Map.Entry<String, Integer> chocolate : readySwords.entrySet()) {
            System.out.printf("%s: %d%n", chocolate.getKey(), chocolate.getValue());
        }
    }
}
