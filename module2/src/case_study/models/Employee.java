package case_study.models;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private String level;
    private String position;
    private int salary;

    public Employee() {

    }

    public Employee(String level, String position, int salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(int id, String name, int age, String gender, String email,
                    String level, String position, int salary) {
        super(id, name, age, gender, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID: " + super.id + ", Name: " + super.name + ", Age: " + super.age + ", Gender: " + super.gender + ", Email: " + super.email + ", Level: " + level + ", Position: " + position + ", Salary: " + salary + "]";
    }
}
