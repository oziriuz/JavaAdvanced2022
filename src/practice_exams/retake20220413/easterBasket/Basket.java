package practice_exams.retake20220413.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        Egg temp = getEgg(color);
        return data.remove(temp);
    }

    public Egg getStrongestEgg() {
        int tempStrength = Integer.MIN_VALUE;
        int tempN = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getStrength() > tempStrength) {
                tempStrength = data.get(i).getStrength();
                tempN = i;
            }
        }
        return data.get(tempN);
    }

    public Egg getEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", this.material));
        for (Egg egg : data) {
            sb.append(String.format("%n%s", egg.toString()));
        }
        return sb.toString();
    }
}
