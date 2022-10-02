package SetsAndMapsAdvanced.lab;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> stores = new TreeMap<>();

        while (!input.equals("Revision")) {
            String store = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            stores.putIfAbsent(store, new LinkedHashMap<>());
            stores.get(store).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> store : stores.entrySet()) {
            System.out.println(store.getKey() + "->");
            for (Map.Entry<String, Double> product : store.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}
