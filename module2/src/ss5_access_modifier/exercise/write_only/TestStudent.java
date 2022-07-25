package ss5_access_modifier.exercise.write_only;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Tan");
        System.out.println(student.getName());
        Student.setClasses("A04");
        System.out.println(student.getClasses());
    }
}
