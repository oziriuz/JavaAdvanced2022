package defining_classes.exercise.speed_racing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double fuelExpenseFor1km = Double.parseDouble(input[2]);

            Car car = new Car(model, fuel, fuelExpenseFor1km);
            cars.putIfAbsent(model, car);
        }

        String end = "End";
        String input = scanner.nextLine();

        while (!input.equals(end)) {
            String model = input.split("\\s+")[1];
            int distanceToGo = Integer.parseInt(input.split("\\s+")[2]);

            if (!cars.get(model).drive(distanceToGo)) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        for (Car c : cars.values()) {
            System.out.println(c);
        }
    }
}
