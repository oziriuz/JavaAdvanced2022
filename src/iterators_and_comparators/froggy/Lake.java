package iterators_and_comparators.froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private final List<Integer> lake;

    public Lake(Integer... elements) {
        this.lake = Arrays.asList(elements);
    }

    private class Froggy implements Iterator<Integer> {

        private int index = 0;
        boolean firstFinished = false;

        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {
            Integer element = lake.get(index);
            index += 2;

            if (index >= lake.size() && !firstFinished) {
                index = 1;
                firstFinished = true;
            }
            return element;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Froggy();
    }
}
