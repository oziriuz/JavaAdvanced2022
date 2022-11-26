package regular_exam_advanced.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                return data.remove(animal);
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
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

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The regular_exam.shelter has the following animals:%n"));
        for (Animal animal : data) {
            sb.append(String.format("%s %s%n", animal.getName(), animal.getCaretaker()));
        }
        return sb.toString();
    }
}
