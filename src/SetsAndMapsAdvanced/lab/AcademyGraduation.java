package SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }

            double averageGrade = sum / grades.length;
            students.put(name, averageGrade);
        }

        for (Map.Entry<String, Double> student : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", student.getKey(), student.getValue());
        }
    }
}
