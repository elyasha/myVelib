package core.components;

import java.util.Objects;

public abstract class Bicycle {
    private final int id = generateUniqueID();
    private static int numberOfBicycles = 0;

    private int generateUniqueID() {
        return ++numberOfBicycles;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return id == bicycle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
