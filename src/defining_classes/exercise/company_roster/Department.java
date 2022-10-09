package defining_classes.exercise.company_roster;

import java.util.*;

public class Department implements Comparable<Department> {
    private final String name;
    public Double averageSalary = 0.00;
    Set<Employee> employees = new TreeSet<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        this.averageSalary = calculateAverageSalary();
    }

    private double calculateAverageSalary() {
        double sum = 0;

        if (this.employees == null) {
            return 0;
        }

        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }

        return sum / this.employees.size();
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public int compareTo(Department d) {
        //reversed
        return d.averageSalary.compareTo(this.averageSalary);
        //return this.averageSalary.compareTo(d.averageSalary);
    }
}
