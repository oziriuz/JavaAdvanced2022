package practice_exams.exam20220625;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Deque<Double> milkQueue = new ArrayDeque<>();
        for (String s : input) {
            milkQueue.offer(Double.parseDouble(s));
        }

        input = scanner.nextLine().split(" ");
        Deque<Double> powderStack = new ArrayDeque<>();
        for (String s : input) {
            powderStack.push(Double.parseDouble(s));
        }

        Map<Double, String> recipes = new HashMap<>();
        recipes.put(30.00, "Milk Chocolate");
        recipes.put(50.00, "Dark Chocolate");
        recipes.put(100.00, "Baking Chocolate");

        Map<String, Integer> readyChocolates = new TreeMap<>();

        while (!milkQueue.isEmpty() && !powderStack.isEmpty()) {
            double milk = milkQueue.poll();
            double powder = powderStack.pop();
            double mix = milk + powder;
            double powderPercent = (powder / mix) * 100.0;

            if (recipes.containsKey(powderPercent)) {
                readyChocolates.putIfAbsent(recipes.get(powderPercent), 0);
                readyChocolates.put(recipes.get(powderPercent), readyChocolates.get(recipes.get(powderPercent)) + 1);
            } else {
                milk += 10.0;
                milkQueue.offer(milk);
            }
        }

        if (readyChocolates.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> chocolate : readyChocolates.entrySet()) {
            System.out.printf("# %s --> %d%n", chocolate.getKey(), chocolate.getValue());
        }
    }
}
