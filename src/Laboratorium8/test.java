package Laboratorium8;

public class test {
    public static void main(String[] args) {
        Table t1 = new Table(100, 20, 60);
        Table t2 = new Table(200, 60, 60);
        Table t3 = new Table(120, 100, 100);
        SinglyLinkedList<Table> sl = new SinglyLinkedList<Table>();
        //boolean add
        System.out.println(sl.add(t1));
        System.out.println(sl);

        //void add
        sl.add(0,t2);
        System.out.println(sl);

        sl.add(1,t3);
        System.out.println(sl);
//
//        sl.
//
//        //boolean remove
//        System.out.println(sl.remove(0));
//        System.out.println(sl);

        //boolean contains
        System.out.println(sl.contains(t2));
        System.out.println(sl.contains(t3));

        //get
        System.out.println(sl.get(0));

        //indexof
        System.out.println(sl.indexOf(t1));
        System.out.println(sl.indexOf(t3));

        //isEmpty1
        System.out.println(sl.isEmpty());

        System.out.println(sl.size());

        //void clear
        sl.clear();
        System.out.println(sl);

        //isEmpty2
        System.out.println(sl.isEmpty());
        System.out.println(sl.size());

    }
}
