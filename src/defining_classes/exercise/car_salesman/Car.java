package defining_classes.exercise.car_salesman;

public class Car {
    private final String model;
    private final Engine engine;
    private final String weight;
    private final String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                             "%s:%n" +
                             "Power: %s%n" +
                             "Displacement: %s%n" +
                             "Efficiency: %s%n" +
                             "Weight: %s%n" +
                             "Color: %s",
                this.model,
                this.engine.getModel(),
                this.engine.getPower(),
                this.engine.getDisplacement(),
                this.engine.getEfficiency(),
                this.weight,
                this.color);

    }
}
