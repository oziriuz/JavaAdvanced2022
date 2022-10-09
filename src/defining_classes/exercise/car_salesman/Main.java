package defining_classes.exercise.car_salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Engine> engines = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String engineModel = input[0];
            int enginePower = Integer.parseInt(input[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            if (input.length == 3) {
                if (isStringInteger(input[2])) {
                    displacement = input[2];
                } else {
                    efficiency = input[2];
                }
            }

            if (input.length == 4) {
                displacement = input[2];
                efficiency = input[3];
            }

            Engine engine = new Engine(engineModel, enginePower, displacement, efficiency);

            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String carModel = input[0];
            String engineModel = input[1];
            Engine engine = new Engine();
            for (Engine item : engines) {
                if(engineModel.equals(item.getModel())) {
                    engine = item;
                    break;
                }
            }

            String weight = "n/a";
            String color = "n/a";

            if (input.length == 3) {
                if (isStringInteger(input[2])) {
                    weight = input[2];
                } else {
                    color = input[2];
                }
            }

            if (input.length == 4) {
                weight = input[2];
                color = input[3];
            }

            Car car = new Car(carModel, engine, weight, color);
            cars.add(car);
        }

        for (Car item : cars) {
            System.out.println(item.toString());
        }
    }

    public static boolean isStringInteger(String number ){
        try{
            Integer.parseInt(number);
        }catch(Exception e ){
            return false;
        }
        return true;
    }
}
