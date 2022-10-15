package generics.exercise.custom_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> values;

    public CustomList() {
        values = new ArrayList<>();
    }

    private class customIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < values.size();
        }

        @Override
        public T next() {
            return values.get(index++);
        }
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    public int counterGreaterThan(T element) {
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return values.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return values.stream().min(Comparable::compareTo).get();
    }

    public int size() {
        return values.size();
    }

    public T get(int index) {
        return values.get(index);
    }


    @Override
    public Iterator<T> iterator() {
        return new customIterator();
    }
}
