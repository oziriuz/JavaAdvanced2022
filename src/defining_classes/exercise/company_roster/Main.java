package defining_classes.exercise.company_roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;

            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            }

            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).addEmployee(employee);
        }

        double maxSalary = Double.MIN_VALUE;
        String maxSalaryDepartment = "";

        for (Map.Entry<String, Department> d : departments.entrySet()) {
            if (d.getValue().averageSalary > maxSalary) {
                maxSalary = d.getValue().averageSalary;
                maxSalaryDepartment = d.getKey();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", maxSalaryDepartment);
        departments.get(maxSalaryDepartment).printEmployees();
    }
}

