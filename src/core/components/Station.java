package core.components;

import java.util.ArrayList;
import java.util.List;

public abstract class Station {
    private final int id = generateUniqueID();
    private static int numberOfStations = 0;

    private int generateUniqueID() {
        return ++numberOfStations;
    }
    private int numberOfParkingSlots;
    private float latitude;
    private float longitude;
    private boolean status;  // Can be "on service" of "offline"
    private List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();



    private List<ParkingSlot> generateAllSlots(List<ParkingSlot> parkingSlots) {
        for (int cpt = 0; cpt < this.numberOfParkingSlots; cpt++) {
            ParkingSlot slot = new ParkingSlot();
            parkingSlots.add(slot);
        }
        return parkingSlots;
    }

    public int getId() {
        return this.id;
    }

    public int getNumberOfParkingSlots() {
        return this.numberOfParkingSlots;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean new_status) {
        this.status = new_status;
    }

    public List<Float> getPosition() {
        List<Float> coords = new ArrayList<Float>(2);
        coords.add(this.latitude);
        coords.add(this.longitude);
        return coords;
    }

    public void setPosition(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setNumberOfParkingSlots(int numberOfParkingSlots) {
        this.numberOfParkingSlots = numberOfParkingSlots;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
