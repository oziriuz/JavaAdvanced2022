package defining_classes.exercise.family_tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String end = "End";

        Set<Person> people = new LinkedHashSet<>();

        String personToFind = scanner.nextLine();

        String input = scanner.nextLine();

        Deque<String> connections = new ArrayDeque<>();

        while (!input.equals(end)) {
            if (input.contains(" - ")) {
                connections.offer(input);
            } else {
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String birthday = data[2];

                people.add(new Person(name, birthday));
            }

            input = scanner.nextLine();
        }

        while (!connections.isEmpty()) {
            String[] data = connections.poll().split(" - ");
            String parentData = data[0];
            String childData = data[1];

            for (Person person : people) {
                //add child to parent
                extracted(person, parentData, people, childData, person.getChildren());

                //add parent to child
                extracted(person, childData, people, parentData, person.getParents());
            }
        }

        for (Person p : people) {
            if (p.getName().equals(personToFind)) {
                System.out.println(p.getForPrint());
            } else if (p.getBirthday().equals(personToFind)) {
                System.out.println(p.getForPrint());
            }
        }
    }

    private static void extracted(Person p, String dataToSearchIn, Set<Person> people, String dataForAdding, Set<Person> SetForAdding) {
        if (p.getName().equals(dataToSearchIn) || p.getBirthday().equals(dataToSearchIn)) {
            for (Person person : people) {
                if (person.getName().equals(dataForAdding) || person.getBirthday().equals(dataForAdding)) {
                    SetForAdding.add(person);
                }
            }
        }
    }
}
