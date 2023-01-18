package Laboratorium7;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Point {
    private final double X;
    private final double Y;

    public static final Point zeroZero=new Point(0.0 ,0.0);
    public static final Point oneZero=new Point(1.0 ,0.0);
    public static Point of(double x, double y){
        return new Point(x,y);
    }

    private Point (double x, double y){
        this.X=x;
        this.Y=y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    Point move(double vx, double vy){
        double newX = this.getX()+vx;
        double newY = this.getY()+vy;

        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    Point symetryOx(){
        double newX = this.getX();
        double newY = -this.getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    Point symetryOy(){
        double newX = -this.getX();
        double newY = this.getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    Point rotate(int degree){
        double newX = this.getX()*Math.cos(Math.toRadians(degree))+this.getY()*Math.sin(Math.toRadians(degree));
        double newY = -this.getX()*Math.sin(Math.toRadians(degree))+this.getY()*Math.cos(Math.toRadians(degree));
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }


    @Override
    public String toString() {
        NumberFormat df = new DecimalFormat("#0.0");
        return "("+df.format(getX())+", "+df.format(getY())+")";
    }
}
