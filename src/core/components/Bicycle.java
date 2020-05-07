package core.components;

public abstract class Bicycle {
    private final int id = generateUniqueID();
    private static int numberOfBicycles = 0;

    private int generateUniqueID() {
        return ++numberOfBicycles;
    }

}
