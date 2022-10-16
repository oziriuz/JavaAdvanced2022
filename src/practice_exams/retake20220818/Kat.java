package practice_exams.retake20220818;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] numberOfLicensePlates = Arrays.stream(scanner.nextLine().split(", "))
                .mapToLong(Long::parseLong)
                .toArray();

        Deque<Long> plateQueue = new ArrayDeque<>();
        for (long number : numberOfLicensePlates) {
            plateQueue.offer(number);
        }

        long[] numberOfCars = Arrays.stream(scanner.nextLine().split(", "))
                .mapToLong(Long::parseLong)
                .toArray();

        Deque<Long> carQueue = new ArrayDeque<>();
        //add the cars in reverse order
        for (int i = numberOfCars.length - 1; i >= 0; i--) {
            carQueue.offer(numberOfCars[i]);
        }

        long days = 0;
        long registeredCars = 0;

        while (!carQueue.isEmpty() && !plateQueue.isEmpty()) {
            days++;
            long numberOfPlatesPerDay = plateQueue.poll();
            long numberOfCarsPerDay = carQueue.poll();

            if (numberOfPlatesPerDay > 2 * numberOfCarsPerDay) {
                registeredCars += numberOfCarsPerDay;
                plateQueue.offer(numberOfPlatesPerDay - 2 * numberOfCarsPerDay);
            } else if (numberOfPlatesPerDay < 2* numberOfCarsPerDay){
                registeredCars += numberOfPlatesPerDay / 2;
                carQueue.offer(numberOfCarsPerDay - numberOfPlatesPerDay / 2);
            } else {
                registeredCars += numberOfCarsPerDay;
            }
        }

        long remainingPlates = 0;
        while (!plateQueue.isEmpty()) {
            remainingPlates += plateQueue.poll();
        }

        long remainingCars = 0;
        while (!carQueue.isEmpty()) {
            remainingCars += carQueue.poll();
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (remainingPlates > 0) {
            System.out.printf("%d license plates remain!", remainingPlates);
        } else if (remainingCars > 0) {
            System.out.printf("%d cars remain without license plates!", remainingCars);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
