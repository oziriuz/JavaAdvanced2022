package defining_classes.lab.car_info;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Car> carSet = new LinkedHashSet<>();

        while (n-- > 0) {
            String input = scanner.nextLine();

            String brand = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            int hp = Integer.parseInt(input.split("\\s+")[2]);
            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(hp);

            carSet.add(car);
        }

        for (Car car : carSet) {
            System.out.printf(car.carInfo());
        }
    }
}
