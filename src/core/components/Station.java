package core.components;

public abstract class Station {
    private final int id = generateUniqueID();
    private static int numberOfStations = 0;

    private int generateUniqueID() {
        return ++numberOfStations;
    }


}
