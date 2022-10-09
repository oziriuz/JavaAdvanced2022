package defining_classes.exercise.google;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private final String name;
    private Company company = new Company();
    private Car car = new Car();

    Set<Pokemon> pokemons = new LinkedHashSet<>();
    Set<Parent> parents = new LinkedHashSet<>();
    Set<Child> children = new LinkedHashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public void setCompany(String companyName, String department, double salary) {
        this.company = new Company(companyName, department, salary);
    }

    public void setCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                        "Company:%n%s" +
                        "Car:%n%s" +
                        "Pokemon:%n%s" +
                        "Parents:%n%s" +
                        "Children:%n%s",
                this.name,
                this.company,
                this.car,
                getCollectionToString(this.pokemons),
                getCollectionToString(this.parents),
                getCollectionToString(this.children));
    }

    private <T> String getCollectionToString(Set<T> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (T t : collection) {
            stringBuilder.append(String.format("%s", t));
        }
        return String.valueOf(stringBuilder);
    }
}
