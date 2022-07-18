package ss4_class_and_object_in_java.bai_tap.Fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(Fan.fast, 10, true, "yellow");
        Fan fan2 = new Fan(5, false, "blue");

        System.out.println("Fan1: " + fan1.toString());
        System.out.println("Fan2: " + fan2.toString());
    }
}
