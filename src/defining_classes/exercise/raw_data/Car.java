package defining_classes.exercise.raw_data;

import java.util.List;

public class Car {
    private final String model;
    private final Engine engine;
    private final Cargo cargo;
    private final List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public boolean hasLowPressureTyre() {
        for (Tire tire : this.getTires()) {
            if (tire.isLowPressure()) {
                return true;
            }
        }

        return false;
    }

    public boolean hasHighPowerEngine() {
        return this.engine.getPower() > 250;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
