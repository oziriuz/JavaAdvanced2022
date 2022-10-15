package generics.exercise.box;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int first, int second) {
        Collections.swap(values, first, second);
    }

    public int countOfGreaterItems(T element){
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return sb.toString();
    }
}
