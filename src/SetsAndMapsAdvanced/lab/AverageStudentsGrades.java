package SetsAndMapsAdvanced.lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            calculateAndPrintAverageGrade(entry.getValue());
        }
    }

    private static void calculateAndPrintAverageGrade(List<Double> grades) {
        double sumOfGrades = 0;
        for (Double grade : grades) {
            System.out.printf("%.2f ", grade);
            sumOfGrades += grade;
        }
        double averageGrade = sumOfGrades / grades.size();

        System.out.printf("(avg: %.2f)%n", averageGrade);
    }
}
