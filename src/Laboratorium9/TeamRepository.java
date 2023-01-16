package Laboratorium9;

import java.util.List;
import java.util.function.Predicate;

public class TeamRepository implements RepositoryInterface{

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean update(Object oldValue, Object newValue) {
        return false;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public List filter(Predicate predicate) {
        return null;
    }

    @Override
    public boolean remove(Object object) {
        return false;
    }
}
