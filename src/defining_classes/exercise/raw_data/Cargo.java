package defining_classes.exercise.raw_data;

public class Cargo {
    private final int weight;
    private final String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public boolean isFragile() {
        return this.type.equals("fragile");
    }

    public boolean isFlammable() {
        return this.type.equals("flamable");
    }
}
