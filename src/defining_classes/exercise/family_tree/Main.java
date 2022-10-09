package defining_classes.exercise.family_tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String end = "End";

        Set<Person> people = new HashSet<>();

        String personToFind = scanner.nextLine();
        Person person = new Person(personToFind);

        people.add(person);
        String input = scanner.nextLine();

        Deque<String> parentChildQueue = new ArrayDeque<>();
        Deque<String> personQueue = new ArrayDeque<>();

        while (!input.equals(end)) {
            if (input.contains(" - ")) {
                parentChildQueue.offer(input);
            } else {
                personQueue.offer(input);
            }

            input = scanner.nextLine();
        }

        while (!personQueue.isEmpty()) {
            String[] data = personQueue.poll().split("\\s+");
            String name = data[0] + " " + data[1];
            String birthday = data[2];

            boolean isPresent = false;

            for (Person p : people) {
                if (p.getName().equals(name)) {
                    p.setBirthday(birthday);
                    isPresent = true;
                } else if (p.getBirthday().equals(birthday)) {
                    p.setName(name);
                    isPresent = true;
                }
            }

            if (!isPresent) {
                people.add(new Person(name, birthday));
            }
        }

        while (!parentChildQueue.isEmpty()) {
            String[] data = parentChildQueue.poll().split(" - ");
            String parentData = data[0];
            String childData = data[1];

            String parentName = "";
            String parentBirthday = "";
            String childName = "";
            String childBirthday = "";

            for (Person p : people) {
                if (p.getName().equals(parentData)) {
                    parentName = parentData;
                    parentBirthday = p.getBirthday();
                } else if (p.getBirthday().equals(parentData)) {
                    parentName = p.getName();
                    parentBirthday = parentData;
                }

                if (p.getName().equals(childData)) {
                    childName = childData;
                    childBirthday = p.getBirthday();
                } else if (p.getBirthday().equals(childData)) {
                    childName = p.getName();
                    childBirthday = childData;
                }
            }

            for (Person p : people) {
                if (p.getName().equals(parentData) || p.getBirthday().equals(parentData)) {
                    p.addChild(childName, childBirthday);
                }

                if (p.getName().equals(childData) || p.getBirthday().equals(childData)) {
                    p.addParent(parentName, parentBirthday);
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
