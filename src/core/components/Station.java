package core.components;

public abstract class Station {
    private final int id = generateUniqueID();
    private static int numberOfStations = 0;

    private int generateUniqueID() {
        return ++numberOfStations;
    }

    private int numberOfParkingSlots;
    private float latitude;
    private float longitude;
    private String status;  // Can be "on service" of "offline"



}
