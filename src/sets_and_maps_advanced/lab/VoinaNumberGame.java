package sets_and_maps_advanced.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = getCardsFromConsole(scanner);
        LinkedHashSet<Integer> secondDeck = getCardsFromConsole(scanner);

        int rounds = 50;

        while (rounds-- > 0) {
            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);
            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }

        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }


    private static LinkedHashSet<Integer> getCardsFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
