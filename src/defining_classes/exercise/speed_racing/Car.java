package defining_classes.exercise.speed_racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelExpenseFor1km;
    private int distanceTraveled = 0;

    public Car(String model, double fuelAmount, double fuelExpenseFor1km) {
        setModel(model);
        setFuelAmount(fuelAmount);
        setFuelExpenseFor1km(fuelExpenseFor1km);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelExpenseFor1km(double fuelExpenseFor1km) {
        this.fuelExpenseFor1km = fuelExpenseFor1km;
    }

    public boolean drive(int distance) {
        int maxDistance = calculateMaxDistance();

        if (maxDistance >= distance) {
            distanceTraveled += distance;
            fuelAmount -= distance * fuelExpenseFor1km;
            return true;
        }

        return false;
    }

    private int calculateMaxDistance() {
        return (int) (fuelAmount / fuelExpenseFor1km);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
