package defining_classes.exercise.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String end = "End";

        String input = scanner.nextLine();

        Map<String, Person> people = new HashMap<>();
        while (!input.equals(end)) {
            String[] data = input.split("\\s+");

            String personName = data[0];
            String command = data[1];

            people.putIfAbsent(personName, new Person(personName));

            switch (command) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);

                    people.get(personName).setCompany(companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];

                    people.get(personName).pokemons.add(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];

                    people.get(personName).parents.add(new Parent(parentName, parentBirthday));
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];

                    people.get(personName).children.add(new Child(childName, childBirthday));
                    break;
                case "car":
                    String model = data[2];
                    int speed = Integer.parseInt(data[3]);

                    people.get(personName).setCar(model, speed);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        String personToFind = scanner.nextLine();

        System.out.println(people.get(personToFind));
    }
}
