package ss4_class_and_object_in_java.bai_tap.Fan;

public class Fan {
    public static final int slow = 1;
    public static final int medium = 2;
    public static final int fast = 3;
    private int speed = fast;
    private double radius = 5;
    private boolean on = false;
    private String color = "blue";

    public Fan() {
    }

    public Fan(int speed, double radius, boolean on, String color) {
        this.speed = speed;
        this.radius = radius;
        this.on = on;
        this.color = color;
    }

    public Fan(double radius, boolean on, String color) {
        this.radius = radius;
        this.on = on;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.on == true) {
            return "Speed: " + this.speed + ", Color: " + this.color + ", Radius: " + this.radius + ", Fan is on";
        } else {
            return "Color: " + this.color + ", Radius: " + this.radius + ", Fan is off";
        }
    }

}
