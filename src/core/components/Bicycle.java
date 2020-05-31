package core.components;

import java.util.Objects;

/**
 * The (abstract) Bicycle class : It defines a bicycle on the application
 */
public abstract class Bicycle {

    /**
     * id : This is the unique id given to any bicycle
     */
    private final int id = generateUniqueID();

    /**
     * numberOfBicycles : This is the variable that will keep the number of bicycles in the application
     */
    private static int numberOfBicycles = 0;

    /**
     * This methods generate an unique id each time a bicycle object is created
     *
     * @return the unique id, that is given by the number of bicycles in the application
     */
    private int generateUniqueID() {
        return ++numberOfBicycles;
    }

    /**
     * getter for id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * getter for numberOfBicycles
     *
     * @return numberOfBicycles
     */
    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    /**
     * the toString method for the Bicycle class with some representation for the class
     *
     * @return a message that represents the class
     */
    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                '}';
    }

    /**
     * equals method for the Bicycle class
     *
     * @param o an object
     * @return true, if the two objects are "equal"; false, otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return id == bicycle.id;
    }

    /**
     * hashCode method for the Bicycle class
     *
     * @return hash(id)
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
