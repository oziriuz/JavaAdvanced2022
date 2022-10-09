package sets_and_maps_advanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingSet = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split(", ");
            String direction = token[0];
            String carNumber = token[1];
            if (direction.equals("IN")) {
                parkingSet.add(carNumber);
            }

            if (direction.equals("OUT")) {
                parkingSet.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        if (parkingSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingSet) {
                System.out.println(car);
            }
        }
    }
}
