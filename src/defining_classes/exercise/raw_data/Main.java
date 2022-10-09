package defining_classes.exercise.raw_data;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Car> cars = new LinkedHashSet<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();

            for (int j = 5; j < input.length; j += 2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            printFragileAndLowTirePressure(cars);
        }

        if (command.equals("flamable")) {
            printFlammableAndHighPower(cars);
        }
    }

    public static void printFragileAndLowTirePressure(Set<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().isFragile() && car.hasLowPressureTyre()) {
                System.out.println(car);
            }
        }
    }

    public static void printFlammableAndHighPower(Set<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().isFlammable() && car.hasHighPowerEngine()) {
                System.out.println(car);
            }
        }
    }
}
