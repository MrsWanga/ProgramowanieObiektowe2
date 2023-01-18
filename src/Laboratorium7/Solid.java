package Laboratorium7;

import java.util.Objects;

public abstract class Solid {
    public Unit unit;

    public Solid (Unit unit){
        this.unit=unit;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        Solid solid = (Solid) o;
        return unit == solid.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit);
    }

   public abstract double volume();
   public abstract double surfaceArea();
}
