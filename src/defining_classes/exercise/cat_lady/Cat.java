package defining_classes.exercise.cat_lady;

public abstract class Cat {
    private final String name;
    private final String breed;

    public String getName() {
        return name;
    }

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.breed, this.name);
    }
}
