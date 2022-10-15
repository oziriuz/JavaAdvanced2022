package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable {
    private final List<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void add(T... elements) {
        this.elements.addAll(Arrays.asList(elements));
    }

    public T pop() {
        if (elements.isEmpty()) {
            return null;
        }

        T temp = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return temp;
    }

    private class StackIterator implements Iterator<T> {
        int index = elements.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            return elements.get(index--);
        }
    }

    @Override
    public Iterator iterator() {
        return new StackIterator();
    }
}
