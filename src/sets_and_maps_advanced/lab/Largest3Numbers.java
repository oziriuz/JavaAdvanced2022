package sets_and_maps_advanced.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int count = 0;

        for (int value : list) {
            System.out.print(value + " ");
            count++;
            if (count > 2){
                break;
            }
        }
    }
}
