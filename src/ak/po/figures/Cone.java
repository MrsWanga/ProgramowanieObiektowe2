package ak.po.figures;

public class Cone extends Solid{
    private double r;
    private double h;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Cone(Unit unit) {
        super(unit);
    }

    @Override
    public double volume() {
        return 1.0/3*Math.PI*Math.pow(this.r,2)*this.h;
    }

    @Override
    public double surfaceArea() {
        double l = Math.sqrt(Math.pow(this.r,2)+Math.pow(this.h,2));
        return Math.PI*Math.pow(this.r,2)+Math.PI*r*l;
    }

    public boolean equals(Object o) {
        double epsilon = 0.5;
        Cone cone = (Cone) o;
        return super.equals(o)
                && Double.compare(cone.r, this.r) <= epsilon
                && Double.compare(cone.h, this.h) <= epsilon;
    }
}
