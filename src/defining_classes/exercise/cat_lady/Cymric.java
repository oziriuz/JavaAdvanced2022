package defining_classes.exercise.cat_lady;

public class Cymric extends Cat {
    private final double furLength;

    public Cymric(String name, String breed, double furLength) {
        super(name, breed);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.furLength);
    }
}
