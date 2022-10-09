package sets_and_maps_advanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> result = new LinkedHashMap<>();

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : numbers) {
            result.putIfAbsent(number, 0);
            result.put(number, result.get(number) + 1);
        }

        for (Map.Entry<Double, Integer> entry : result.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
