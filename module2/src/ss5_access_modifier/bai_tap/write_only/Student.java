package ss5_access_modifier.bai_tap.write_only;

public class Student {
    private String name = "John";
    private static String classes = "C02";

    public Student() {}

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    void setName(String name) {
        this.name = name;
    }

    static void setClasses(String classes) {
        Student.classes = classes;
    }

}
