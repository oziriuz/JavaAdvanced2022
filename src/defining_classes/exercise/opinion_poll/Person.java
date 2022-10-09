package defining_classes.exercise.opinion_poll;

public class Person implements Comparable<Person> {
    private String name;
    private int age = 0;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }
}
