package ss7_abstract_interface.exercise.resizeable;

import ss7_abstract_interface.exercise.resizeable.geometry.Circle;
import ss7_abstract_interface.exercise.resizeable.geometry.Rectangle;
import ss7_abstract_interface.exercise.resizeable.geometry.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 5);
        System.out.println("---Before resize---");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Area = " + shape.countArea());
        }
        System.out.println("---After resize---");
        for (Shape shape : shapes) {
            shape.resize(10);
            System.out.println(shape.toString());
            System.out.println("Area = " + shape.countArea());
        }
    }
}
