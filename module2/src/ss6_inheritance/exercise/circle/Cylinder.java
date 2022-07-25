package ss6_inheritance.exercise.circle;

public class Cylinder extends Circle {
    private int height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, int height) {
        super(radius, color);
        this.height = height;
    }

    public double countVolume() {
        return super.countArea() * height;
    }

    @Override
    public String toString() {
        return super.toString() + ", Volume = " + this.countVolume();
    }
}
