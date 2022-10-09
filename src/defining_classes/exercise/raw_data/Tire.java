package defining_classes.exercise.raw_data;

public class Tire {
    private final double pressure;
    private final int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public boolean isLowPressure() {
        return this.pressure < 1.0;
    }
}
