package defining_classes.exercise.cat_lady;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String end = "End";
        String input = scanner.nextLine();

        Set<Cat> cats = new HashSet<>();

        while (!input.equals(end)) {
            String[] data = input.split("\\s+");

            String breed = data[0];
            String name = data[1];
            double additionalInfo = Double.parseDouble(data[2]);

            Cat cat;

            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, breed, additionalInfo);
                    cats.add(cat);
                    break;
                case "Cymric":
                    cat = new Cymric(name, breed, additionalInfo);
                    cats.add(cat);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, breed, additionalInfo);
                    cats.add(cat);
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }

        String catToFind = scanner.nextLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(catToFind)) {
                System.out.println(cat);
            }
        }
    }
}
