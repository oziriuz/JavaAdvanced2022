package defining_classes.exercise.company_roster;

public class Employee implements Comparable<Employee> {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail(email);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }

    @Override
    public int compareTo(Employee e) {
        //reversed order for comparing - descending order
        return e.salary.compareTo(this.salary);

        //ascending order
        //return this.salary.compareTo(e.salary);
    }
}
