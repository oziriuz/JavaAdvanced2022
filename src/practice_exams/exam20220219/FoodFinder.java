package practice_exams.exam20220219;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Deque<String> vowelQueue = new ArrayDeque<>();
        for (String s : input) {
            vowelQueue.offer(s);
        }

        input = scanner.nextLine().split(" ");
        Deque<String> consonantStack = new ArrayDeque<>();
        for (String s : input) {
            consonantStack.push(s);
        }

        Map<String, String> words = new LinkedHashMap<>();
        words.put("pear", "");
        words.put("flour", "");
        words.put("pork", "");
        words.put("olive", "");

        while (!consonantStack.isEmpty()) {
            String currentC = consonantStack.pop();
            String currentV = vowelQueue.poll();

            for (Map.Entry<String, String> word : words.entrySet()) {
                if (word.getKey().contains(currentC) && !word.getValue().contains(currentC)) {
                    String temp = word.getValue();
                    words.put(word.getKey(), temp + currentC);
                }
                assert currentV != null;
                if (word.getKey().contains(currentV) && !word.getValue().contains(currentV)) {
                    String temp = word.getValue();
                    words.put(word.getKey(), temp + currentV);
                }
            }

            vowelQueue.offer(currentV);
        }

        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (Map.Entry<String, String> entry : words.entrySet()) {
            if (entry.getKey().length() == entry.getValue().length()) {
                counter++;
                result.append(String.format("%s%n", entry.getKey()));
            }
        }

        System.out.println("Words found: " + counter);
        System.out.println(result);
    }
}
