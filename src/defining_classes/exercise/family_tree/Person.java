package defining_classes.exercise.family_tree;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private final String name;
    private final String birthday;

    private final Set<Person> parents = new LinkedHashSet<>();

    private final Set<Person> children = new LinkedHashSet<>();

    public Set<Person> getParents() {
        return parents;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
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
