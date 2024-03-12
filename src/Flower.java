import java.util.Objects;

public class Flower {
    final private double x;
    final private double y;
    final private double z;
    final private double p;
    final private String desc;

    public Flower(double x, double y, double z,double p, String desc) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.p=p;
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

    public double getP() {
        return p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(x, flower.x) == 0 && Double.compare(y, flower.y) == 0 && Double.compare(z, flower.z) == 0 && Double.compare(p, flower.p) == 0 && Objects.equals(desc, flower.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, p, desc);
    }
}
