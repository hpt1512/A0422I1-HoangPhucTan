package ss7_abstract_interface.exercise.colorable.geometry;

import ss7_abstract_interface.exercise.colorable.Colorable;

public class Square extends Shape implements Colorable {
    private double edge;

    public Square() {}

    public Square(double edge) {
        this.edge = edge;
    }

    public Square(String color, boolean filled, double edge) {
        super(color, filled);
        this.edge = edge;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
