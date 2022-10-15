package iterators_and_comparators.person_pattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        return Integer.compare(f.getAge(), s.getAge());
    }
}
