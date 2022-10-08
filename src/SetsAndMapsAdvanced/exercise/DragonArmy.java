package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer[]>> types = new LinkedHashMap<>();

        while (n-- > 0) {
            String input = scanner.nextLine();

            String type = input.split("\\s")[0];
            String name = input.split("\\s")[1];

            int damage;
            int health;
            int armor;

            if (!input.split("\\s")[2].equals("null")) {
                damage = Integer.parseInt(input.split("\\s")[2]);
            } else {
                damage = 45;
            }

            if (!input.split("\\s")[3].equals("null")) {
                health = Integer.parseInt(input.split("\\s")[3]);
            } else {
                health = 250;
            }

            if (!input.split("\\s")[4].equals("null")) {
                armor = Integer.parseInt(input.split("\\s")[4]);
            } else {
                armor = 10;
            }

            types.putIfAbsent(type, new TreeMap<>());
            types.get(type).put(name, new Integer[3]);
            types.get(type).get(name)[0] = damage;
            types.get(type).get(name)[1] = health;
            types.get(type).get(name)[2] = armor;
        }


        types.forEach((key, value) -> {
            System.out.printf("%s::", key);

            double sumDamage = 0;
            double sumHealth = 0;
            double sumArmor = 0;

            for (Map.Entry<String, Integer[]> dragon : value.entrySet()) {
                sumDamage += dragon.getValue()[0];
                sumHealth += dragon.getValue()[1];
                sumArmor += dragon.getValue()[2];
            }

            double averageDamage = sumDamage / value.size();
            double averageHealth = sumHealth / value.size();
            double averageArmor = sumArmor / value.size();

            System.out.printf("(%.2f/%.2f/%.2f)%n", averageDamage, averageHealth, averageArmor);

            for (Map.Entry<String, Integer[]> dragon : value.entrySet()) {
                int damage = dragon.getValue()[0];
                int health = dragon.getValue()[1];
                int armor = dragon.getValue()[2];

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), damage, health, armor);
            }
        });
    }
}
