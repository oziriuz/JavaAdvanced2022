package defining_classes.exercise.family_tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String end = "End";
        Set<Person> people = new LinkedHashSet<>();
        Deque<String> connections = new ArrayDeque<>();

        String personToFind = scanner.nextLine();
        String input = scanner.nextLine();

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
                addConnection(person, people, parentData, person.getChildren(), childData);

                //add parent to child
                addConnection(person, people, childData, person.getParents(), parentData);
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

    private static void addConnection(Person p, Set<Person> people, String personData,
                                      Set<Person> collectionToAddTo, String personDataForAdding) {
        if (p.getName().equals(personData) || p.getBirthday().equals(personData)) {
            collectionToAddTo.add(findPersonByData(people, personDataForAdding));
        }
    }

    public static Person findPersonByData(Set<Person> people, String data) {
        for (Person person : people) {
            if (person.getName().equals(data) || person.getBirthday().equals(data)) {
                return person;
            }
        }

        return null;
    }
}