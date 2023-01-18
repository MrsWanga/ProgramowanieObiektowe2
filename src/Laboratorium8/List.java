package Laboratorium8;

public interface List <E>{
    boolean add(E element);// dodaje element na końcu listy;
    void add(int index, E element);// dodaje element na wskazanej pozycji;
    void clear();//  usuwa wszystkie elementy z listy;
    boolean contains(Object o) ;// sprawdza, czy lista zawiera wskazany element, porównując elementy metodą equals;
    E get(int index) ;//  zwraca element listy znajdujący się na wskazanej pozycji;
    int indexOf(Object o) ;//  zwraca pozycję szukanego elementu na liści lub -1, kiedy nie odnajdzie elementu porównując je metodą equals;
    boolean isEmpty() ;//  czy lista jest pusta;
    boolean remove(int index) throws IndexOutOfBoundsException ;//  usuwa element wskazany numerem indeksu
    int size() ;//  ilość elementów na liście.
}
