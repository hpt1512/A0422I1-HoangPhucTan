package ss5_access_modifier.bai_tap.access_modifier;

public class TestCricle {
    public static void main(String[] args) {
        Cricle cricle = new Cricle(5);
        System.out.println("Radius: " + cricle.getRadius());
        System.out.println("Area: " + Cricle.countArea());

    }
}
