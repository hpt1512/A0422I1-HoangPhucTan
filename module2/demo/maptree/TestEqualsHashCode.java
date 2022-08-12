package maptree;

import java.util.HashSet;
import java.util.Set;

public class TestEqualsHashCode {
    public static void main(String[] args) {
        Student st1 = new Student(1, "Nam", 20);
        Student st2 = new Student(1, "Hung", 20);
//        if (st1 == st2) {
//            System.out.println("Equals");
//        } else {
//            System.out.println("Not Equals");
//        }

        Set<Student> students = new HashSet<>();
        students.add(st1);
        students.add(st2);

        students.stream().forEach(System.out::println);
    }
}
