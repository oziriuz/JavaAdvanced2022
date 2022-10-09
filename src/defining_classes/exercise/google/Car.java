package defining_classes.exercise.google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Car() {

    }

    @Override
    public String toString() {
        if (this.model == null) {
            return "";
        }
        return String.format("%s %s%n", this.model, this.speed);
    }
}
