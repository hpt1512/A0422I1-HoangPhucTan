package ss7_abstract_interface.exercise.colorable;

import ss7_abstract_interface.exercise.colorable.geometry.Circle;
import ss7_abstract_interface.exercise.colorable.geometry.Rectangle;
import ss7_abstract_interface.exercise.colorable.geometry.Shape;
import ss7_abstract_interface.exercise.colorable.geometry.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
    }
}
