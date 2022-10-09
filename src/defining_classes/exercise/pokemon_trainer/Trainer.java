package defining_classes.exercise.pokemon_trainer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class Trainer implements Comparable<Trainer> {
    private final String name;
    private Integer numberOfBadges;
    Set<Pokemon> pokemonSet;

    @Override
    public int compareTo(Trainer t) {
        //reversed sorting
        return t.numberOfBadges.compareTo(this.numberOfBadges);
    }

    public Trainer(String name, Integer numberOfBadges, Set<Pokemon> pokemonSet) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonSet = pokemonSet;
    }

    public String getName() {
        return name;
    }

    public boolean hasFire() {
        for (Pokemon p : pokemonSet) {
            if (p.getElement().equals("Fire")) {
                return true;
            }
        }

        return false;
    }

    public boolean hasWater() {
        for (Pokemon p : pokemonSet) {
            if (p.getElement().equals("Water")) {
                return true;
            }
        }

        return false;
    }

    public boolean hasElectricity() {
        for (Pokemon p : pokemonSet) {
            if (p.getElement().equals("Electricity")) {
                return true;
            }
        }

        return false;
    }

    public void takeOneBadge() {
        this.numberOfBadges++;
    }

    public void loose10HealthOfAllPokemons() {
        Deque<Pokemon> pokemonForRemoval = new ArrayDeque<>();
        for (Pokemon p : this.pokemonSet) {
            p.reduceHealthBy10();

            if (p.getHealth() <= 0) {
                pokemonForRemoval.push(p);
            }
        }

        while (!pokemonForRemoval.isEmpty()) {
            pokemonSet.remove(pokemonForRemoval.pop());
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonSet.size());
    }
}
