package ss4_class_and_object_in_java.exercise.quadratic_equation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        double delta = Math.pow(this.b, 2) - 4 * this.a * this.c;
        return delta;
    }

    public double getRoot1() {
        double root_1 = (-this.b + Math.sqrt(this.getDiscriminant())) / (2 * this.a);
        return root_1;
    }

    public double getRoot2() {
        double root_2 = (-this.b - Math.sqrt(this.getDiscriminant())) / (2 * this.a);
        return root_2;
    }

    public double getRoot() {
        double root = -this.b / (2 * this.a);
        return root;
    }
}
