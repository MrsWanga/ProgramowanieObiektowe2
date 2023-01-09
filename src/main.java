import ak.po.figures.Cuboid;
import ak.po.figures.Unit;

public class main {
    public static void main(String[] args) {
        System.out.println(Point.oneZero.toString());
        System.out.println(Point.zeroZero.toString());
        Point sample = Point.of(-2, 4);
        System.out.println(sample.move(3,0));
        System.out.println(sample.symetryOx());
        System.out.println(sample.symetryOy());
        System.out.println(sample.rotate(90));

        Cuboid one = new Cuboid(Unit.MILIMETRY);
        Cuboid two = new Cuboid(Unit.CENTYMETRY);
        Cuboid three = new Cuboid(Unit.MILIMETRY);
        one.setA(1);
        one.setB(2);
        one.setC(3);

        two.setA(1);
        two.setB(2);
        two.setC(3);

        three.setA(1);
        three.setB(5);
        three.setC(7);

        System.out.println("1and2");
        System.out.println(one.equals(two));
        System.out.println("1and3");
        System.out.println(one.equals(three));

    }

}
