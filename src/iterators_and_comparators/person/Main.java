package iterators_and_comparators.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String end = "END";

        List<Person> people = new ArrayList<>();

        while (!input[0].equals(end)) {
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String town = input[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine().split(" ");
        }

        int n = Integer.parseInt(scanner.nextLine());

        Person personToCheck = people.get(n - 1);
        int equals = 0;

        for (Person person : people) {
            if (person.compareTo(personToCheck) == 0) {
                equals++;
            }
        }

        if (equals > 1) {
            System.out.printf("%d %d %d", equals, people.size() - equals, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
