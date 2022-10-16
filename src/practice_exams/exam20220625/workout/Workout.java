package practice_exams.exam20220625.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private final String type;
    private final int exerciseCount;
    private final List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise temp = getExercise(name, muscle);
        return exercises.remove(temp);
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        int tempCalories = Integer.MIN_VALUE;
        int tempN = 0;
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getBurnedCalories() > tempCalories) {
                tempCalories = exercises.get(i).getBurnedCalories();
                tempN = i;
            }
        }
        return exercises.get(tempN);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", this.type));
        for (Exercise exercise : exercises) {
            sb.append(String.format("%n%s", exercise.toString()));
        }
        return sb.toString();
    }
}
