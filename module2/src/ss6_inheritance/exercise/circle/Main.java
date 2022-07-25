package ss6_inheritance.exercise.circle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "blue");
        Cylinder cylinder = new Cylinder(5, "blue", 10);

        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }
}
