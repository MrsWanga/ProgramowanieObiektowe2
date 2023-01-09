package ak.po.figures;

import java.util.Objects;

public class Cuboid extends Solid{
    public double a;
    public double b;
    public double c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public Unit getUnit() {
        return super.getUnit();
    }

    public Cuboid(Unit unit) {
        super(unit);
    }

    @Override
    public double volume() {
        return this.a*this.b*this.c;
    }

    @Override
    public double surfaceArea() {
        return 2*a*b+2*b*c+2*a*c;
    }

    @Override
    public boolean equals(Object o) {
        double epsilon = 0.5;
        Cuboid cuboid = (Cuboid) o;
        return super.equals(o)
                && Double.compare(cuboid.a, a) <= epsilon
                && Double.compare(cuboid.b, b) <= epsilon
                && Double.compare(cuboid.c, c) <= epsilon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b, c);
    }
}
