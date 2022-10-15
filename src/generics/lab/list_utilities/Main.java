package generics.lab.list_utilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(13, 42, 69, 73, 115, 0);

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));
    }
}
