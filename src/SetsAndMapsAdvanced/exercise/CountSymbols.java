package SetsAndMapsAdvanced.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> symbolMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            symbolMap.putIfAbsent(currentChar, 0);
            int currentValue = symbolMap.get(currentChar);
            symbolMap.put(currentChar, currentValue + 1);
        }

        for (Map.Entry<Character, Integer> entry : symbolMap.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
