package ak.po.figures;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
