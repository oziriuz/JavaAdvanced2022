package defining_classes.exercise.family_tree;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name = "";
    private String birthday = "";

    private final Set<Person> parents = new HashSet<>();
    private final Set<Person> children = new HashSet<>();

    public Person(String personToFind) {
        if (personToFind.contains("/")) {
            this.birthday = personToFind;
        } else {
            this.name = personToFind;
        }
    }

    public Person(String name, String birthday) {
        setName(name);
        setBirthday(birthday);
    }

    public void addChild(String childName, String childBirthday) {
        boolean isPresent = false;
        for (Person child : children) {
            if (child.getName().equals(childName)) {
                child.setBirthday(childBirthday);
                isPresent = true;
            }

            if (child.getBirthday().equals(childBirthday)) {
                child.setName(childName);
                isPresent = true;
            }
        }

        if (!isPresent) {
            children.add(new Person(childName, childBirthday));
        }
    }

    public void addParent(String parentName, String parentBirthday) {
        boolean isPresent = false;
        for (Person parent : parents) {
            if (parent.getName().equals(parentName)) {
                parent.setBirthday(parentBirthday);
                isPresent = true;
            }

            if (parent.getBirthday().equals(parentBirthday)) {
                parent.setName(parentName);
                isPresent = true;
            }
        }

        if (!isPresent) {
            parents.add(new Person(parentName, parentBirthday));
        }
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getForPrint() {
        return String.format("%s %s%n" +
                        "Parents:%n" +
                        "%s" +
                        "Children:%n" +
                        "%s",
                this.name, this.birthday,
                getCollectionToString(parents),
                getCollectionToString(children));
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }

    private <T> String getCollectionToString(Set<T> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T t : collection) {
            stringBuilder.append(String.format("%s%n", t));
        }
        return String.valueOf(stringBuilder);
    }
}
