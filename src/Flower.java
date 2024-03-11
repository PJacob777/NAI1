public class Flower {
    final private double x;
    final private double y;
    final private double z;
    final private String desc;

    public Flower(double x, double y, double z, String desc) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.desc = desc;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getDesc() {
        return desc;
    }
}
