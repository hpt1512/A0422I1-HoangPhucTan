package ss5_access_modifier.exercise.access_modifier;

public class Cricle {
    private static double radius = 1.0;
    private String color = "red";

    public Cricle() {
    }

    public Cricle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public static double countArea() {
        double result = Math.PI * Math.pow(Cricle.radius, 2);
        return result;
    }

}
