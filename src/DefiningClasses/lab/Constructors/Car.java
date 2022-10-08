package DefiningClasses.lab.Constructors;

public class Car {
    private String brand;
    private String Model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        setBrand(brand);
        setModel(model);
        setHorsePower(horsePower);
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public Car(String brand, String model) {
        this(brand, model, -1);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.%n", getBrand(), getModel(), getHorsePower());
    }
}
