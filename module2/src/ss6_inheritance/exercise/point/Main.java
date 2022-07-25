package ss6_inheritance.exercise.point;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(1, 1);
        Point3D point3D = new Point3D(1, 2, 3);

        System.out.println(point2D.toString());
        System.out.println(point3D.toString());

        point3D.setXYZ(4,5,6);
        System.out.println(point3D.toString());
    }
}
