package iterators_and_comparators.person_pattern;

import java.util.Comparator;

public class ComparatorByNameLength implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result = Integer.compare(f.getName().length(), s.getName().length());

        if (result == 0) {
            result = Character.compare(Character.toLowerCase(f.getName().charAt(0)),
                    Character.toLowerCase(s.getName().charAt(0)));
        }

        return result;
    }
}
