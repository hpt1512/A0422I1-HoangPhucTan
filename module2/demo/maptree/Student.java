package maptree;

import java.util.Objects;

public class Student {
    public int id;
    public String name;
    public int age;

    public Student() {}
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }

        Student temp = (Student) o;
        if (this.id == temp.id) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
