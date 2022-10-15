package functional_programing.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("Party!")) {
            String doubleOrRemove = line.split(" ")[0];
            String criteria = line.split(" ")[1];
            String parameter = line.split(" ")[2];

            if (doubleOrRemove.equals("Double")) {
                for (int i = 0; i < guests.size(); i++) {
                    String guest = guests.get(i);
                    if(getPredicate(criteria,parameter).test(guest)){
                        guests.add(i++,guest);
                    }
                }
            } else if (doubleOrRemove.equals("Remove")) {
                guests.removeIf(getPredicate(criteria, parameter));
            }

            line = scanner.nextLine();
        }

        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(guests);
            System.out.println(guests.toString().replace("[", "").replace("]","") +
                    " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String criteria, String parameter) {
        switch (criteria) {
            case "StartsWith":
                return s -> s.startsWith(parameter);
            case "EndsWith":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
        }
        return null;
    }
}
