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

            for (Person parent : people) {
                if (parent.getName().equals(parentData) || parent.getBirthday().equals(parentData)) {
                    for (Person child : people) {
                        if (child.getName().equals(childData) || child.getBirthday().equals(childData)) {
                            //add child to parent
                            parent.getChildren().add(child);
                            //add parent to child
                            child.getParents().add(parent);
                        }
                    }
                }
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
}