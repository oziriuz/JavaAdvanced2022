package iterators_and_comparators.person;

public class Person implements Comparable<Person>{
    private final String name;
    private final int age;
    private final String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person p) {
        int result = p.name.compareTo(this.name);

        if (result == 0) {
            result = Integer.compare(p.age, this.age);
        }

        if (result == 0) {
            result = p.town.compareTo(this.town);
        }

        return result;
    }
}
