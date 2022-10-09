package defining_classes.exercise.cat_lady;

public class Siamese extends Cat {
    private final double earSize;

    public Siamese(String name, String breed, double earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.earSize);
    }
}
