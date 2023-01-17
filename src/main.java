import ak.po.figures.Cone;
import ak.po.figures.Cuboid;
import ak.po.figures.Solid;
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
        Cuboid cuboidOne = new Cuboid(Unit.MILIMETRY,2.0, 3.0, 4.0);
        Cuboid cuboidTwo = new Cuboid(Unit.CENTYMETRY, 2.5, 3.0, 4.0);
        Cuboid cuboidThree = new Cuboid(Unit.MILIMETRY, 2.0, 8.0, 4.0);
        Cuboid cuboidFour = new Cuboid(Unit.CENTYMETRY, 2.0, 3.0, 4.0);
        Cone coneOne = new Cone(Unit.MILIMETRY, 5.5, 4.0);
        Cone coneTwo = new Cone(Unit.CENTYMETRY, 5.5, 4.0);
        Cone coneThree = new Cone(Unit.CENTYMETRY, 7.5, 4.0);
        Cone coneFour = new Cone(Unit.MILIMETRY, 5.6, 4.0);

        Solid [] st=new Solid[8];
        st[0]=cuboidOne;
        st[1]=cuboidTwo;
        st[2]=cuboidThree;
        st[3]=cuboidFour;
        st[4]=coneOne;
        st[5]=coneTwo;
        st[6]=coneThree;
        st[7]=coneFour;
        for (Solid s :st) {
            System.out.println(s);
            System.out.println("Volume="+s.volume());
            System.out.println("Surface="+s.surfaceArea());
            System.out.println("------------");
        }
        //test equals cuboid
        System.out.println();
        System.out.println(cuboidOne + " and " + cuboidTwo);
        System.out.println("Is the same? "+cuboidOne.equals(cuboidTwo));
        System.out.println(cuboidOne + " and " + cuboidThree);
        System.out.println("Is the same? "+cuboidOne.equals(cuboidThree));
        System.out.println(cuboidTwo + " and " + cuboidFour);
        System.out.println("Is the same? "+cuboidTwo.equals(cuboidFour));
        System.out.println();

        //test equals cone
        System.out.println();
        System.out.println(coneOne + " and " + coneTwo);
        System.out.println("Is the same? "+coneOne.equals(coneTwo));
        System.out.println(coneTwo + " and " + coneThree);
        System.out.println("Is the same? "+coneTwo.equals(coneThree));
        System.out.println(coneOne + " and " + coneFour);
        System.out.println("Is the same? "+coneOne.equals(coneFour));

    }

}
