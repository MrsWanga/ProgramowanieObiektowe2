package Laboratorium9;

import Laboratorium8.SinglyLinkedList;

import java.util.List;
import java.util.function.Predicate;

public interface RepositoryInterface <T> {
    boolean add(T object);
    boolean update(T oldValue, T newValue);
    SinglyLinkedList<T> getAll();
    SinglyLinkedList<T> filter(Predicate<T> predicate);
    boolean remove(T object);
}
