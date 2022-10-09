package defining_classes.exercise.opinion_poll;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Person> people = new TreeSet<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        for (Person p : people) {
            if (p.getAge() > 30) {
                System.out.println(p);
            }
        }
    }
}
