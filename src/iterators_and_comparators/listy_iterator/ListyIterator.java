package iterators_and_comparators.listy_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator implements Iterable<String> {
    private final List<String> elements;

    private int index = 0;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }

        return false;
    }

    public void print() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("Invalid Operation!");
        }
        System.out.println(elements.get(index));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int internalIndex;

            @Override
            public boolean hasNext() {
                return internalIndex < elements.size() - 1;
            }

            @Override
            public String next() {
                return elements.get(internalIndex++);
            }
        };
    }

    public void printAll() {
        for (String element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
