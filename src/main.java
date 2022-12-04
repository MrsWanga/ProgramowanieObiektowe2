public class main {
    public static void main(String[] args) {
        System.out.println(Point.oneZero.toString());
        System.out.println(Point.zeroZero.toString());
        Point sample = Point.of(3,4);
        System.out.println(sample.move(3,0));
        System.out.println(sample.symetryOx());
        System.out.println(sample.symetryOy());
        System.out.println(sample.rotate(40));
    }

}
