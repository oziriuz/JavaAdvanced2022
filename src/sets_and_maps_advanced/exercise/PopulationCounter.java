package sets_and_maps_advanced.exercise;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String stop = "report";

        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesTotal = new LinkedHashMap<>();

        while (!input.equals(stop)) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            Integer population = Integer.valueOf(input.split("\\|")[2]);

            countriesTotal.putIfAbsent(country, 0L);
            countriesTotal.put(country, countriesTotal.get(country) + population);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countriesTotal.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());

                    countries.get(country.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
