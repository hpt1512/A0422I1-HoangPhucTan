package ss6_inheritance.exercise.point;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D() {}

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] result = {super.getX(), super.getY(), this.z};
        return result;
    }

    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString() + ", z=" + z;
    }
}
