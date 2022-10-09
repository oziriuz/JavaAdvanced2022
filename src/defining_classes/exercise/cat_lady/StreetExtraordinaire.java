package defining_classes.exercise.cat_lady;

public class StreetExtraordinaire extends Cat {
    private final double decibelsOfMeows;

    public StreetExtraordinaire(String name, String breed, double decibelsOfMeows) {
        super(name, breed);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
    }
}
