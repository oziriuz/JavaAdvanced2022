package defining_classes.exercise.pokemon_trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String battle = "Tournament";
        String end = "End";
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals(battle)) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName, 0, new HashSet<>()));

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.get(trainerName).pokemonSet.add(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals(end)) {
            switch (input) {
                case "Fire":
                    for (Trainer t : trainers.values()) {
                        if (t.hasFire()) {
                            t.takeOneBadge();
                        } else {
                            t.loose10HealthOfAllPokemons();
                        }
                    }
                    break;
                case "Water":
                    for (Trainer t : trainers.values()) {
                        if (t.hasWater()) {
                            t.takeOneBadge();
                        } else {
                            t.loose10HealthOfAllPokemons();
                        }
                    }
                    break;
                case "Electricity":
                    for (Trainer t : trainers.values()) {
                        if (t.hasElectricity()) {
                            t.takeOneBadge();
                        } else {
                            t.loose10HealthOfAllPokemons();
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        trainers.values().stream().sorted().forEach(System.out::println);
    }
}
