package defining_classes.lab.constructors;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Car> carSet = new LinkedHashSet<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String brand = input[0];
            Car car;
            if (input.length == 1) {
                car = new Car(brand);
            } else {
                String model = input[1];
                if (input.length == 2) {
                    car = new Car(brand, model);
                } else {
                    int hp = Integer.parseInt(input[2]);
                    car = new Car(brand, model, hp);
                }
            }

            carSet.add(car);
        }

        for (Car car : carSet) {
            System.out.printf(car.carInfo());
        }
    }
}
