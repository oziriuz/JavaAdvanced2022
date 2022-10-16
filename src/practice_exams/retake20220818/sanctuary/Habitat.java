package practice_exams.retake20220818.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private final int capacity;
    List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                return data.remove(elephant);
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        int tempAge = Integer.MIN_VALUE;
        int tempN = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getAge() > tempAge) {
                tempAge = data.get(i).getAge();
                tempN = i;
            }
        }
        return data.get(tempN);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:");
        for (Elephant elephant : data) {
            sb.append(String.format("%n%s came from: %s", elephant.getName(), elephant.getRetiredFrom()));
        }
        return sb.toString();
    }
}
