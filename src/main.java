import ak.po.figures.Cone;
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

        //test cuboid
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

        System.out.println(one);
        System.out.println("Volume="+one.volume());
        System.out.println("Surface="+one.surfaceArea());

        System.out.println(one + " and " + two);
        System.out.println("Is the same? "+one.equals(two));
        System.out.println(one + " and " + three);
        System.out.println("Is the same? "+one.equals(three));
        System.out.println();

        //test cone
        Cone four = new Cone(Unit.MILIMETRY);
        Cone five = new Cone(Unit.CENTYMETRY);
        Cone six = new Cone(Unit.CENTYMETRY);

        four.setR(2.6);
        four.setH(5);

        five.setR(2);
        five.setH(5);

        six.setR(2.1);
        six.setH(5.1);

        System.out.println(five);
        System.out.println("Volume="+five.volume());
        System.out.println("Surface="+five.surfaceArea());

        System.out.println(four + " and " + five);
        System.out.println("Is the same? "+four.equals(five));
        System.out.println(five + " and " + six);
        System.out.println("Is the same? "+five.equals(six));

    }

}
