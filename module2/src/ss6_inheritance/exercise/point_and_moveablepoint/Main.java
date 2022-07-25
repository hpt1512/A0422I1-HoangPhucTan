package ss6_inheritance.exercise.point_and_moveablepoint;

public class Main {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(1, 2, 1, 1);

        System.out.println(moveablePoint);
        MoveablePoint moveablePoint1 = moveablePoint.move();
        System.out.println(moveablePoint1);
        System.out.println(moveablePoint.move());
    }
}
