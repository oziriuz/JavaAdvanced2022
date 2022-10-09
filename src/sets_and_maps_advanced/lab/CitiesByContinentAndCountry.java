package sets_and_maps_advanced.lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countries.get(country);
            cities.add(city);
        }

        continents.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cityList) -> {
                String cities = String.join(", ", cityList);
                System.out.println("  " + country + " -> " + cities);
            });
        });
    }
}
