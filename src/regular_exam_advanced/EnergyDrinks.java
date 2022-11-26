package regular_exam_advanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Deque<Integer> caffeineStack = new ArrayDeque<>();
        for (String s : input) {
            caffeineStack.push(Integer.parseInt(s.trim()));
        }

        input = scanner.nextLine().split(", ");
        Deque<Integer> drinksQueue = new ArrayDeque<>();
        for (String s : input) {
            drinksQueue.offer(Integer.parseInt(s.trim()));
        }
        int caffeineLimit = 300;

        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()) {
            int lastCaffeine = caffeineStack.pop();
            int firstDrink = drinksQueue.poll();
            int dose = lastCaffeine * firstDrink;

            if (dose <= caffeineLimit) {
                caffeineLimit -= dose;
            } else {
                drinksQueue.offer(firstDrink);
                caffeineLimit += 30;

                if (caffeineLimit > 300) {
                    caffeineLimit = 300;
                }
            }
        }

        if (!drinksQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Drinks left: ");
            while (!drinksQueue.isEmpty()) {
                sb.append(drinksQueue.poll());
                sb.append(", ");
            }
            sb.replace(sb.length()-2, sb.length()-1, "");
            System.out.println(sb);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", 300 - caffeineLimit);
    }
}

