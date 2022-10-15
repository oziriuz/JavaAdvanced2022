package generics.exercise.tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(" ");
        String name = input[0] + " " + input[1];
        String addresses = input[2];
        String city = input[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, addresses, city);

        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer litersOfBeer = Integer.parseInt(input[1]);
        Boolean isDrunk = input[2].equals("drunk");
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(firstName, litersOfBeer, isDrunk);


        input = scanner.nextLine().split(" ");
        String cardholderName = input[0];
        Double bankBalance = Double.parseDouble(input[1]);
        String bankName = input[2];
        Threeuple<String, Double, String> thirdTreeuple = new Threeuple<>(cardholderName, bankBalance, bankName);


        System.out.println(firstThreeuple);
        System.out.println(secondThreeuple);
        System.out.println(thirdTreeuple);
    }
}
