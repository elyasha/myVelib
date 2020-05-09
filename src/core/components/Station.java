package core.components;

import java.util.ArrayList;
import java.util.List;

public abstract class Station {
    private final int id;
    private static int numberOfStations = 0;
 
    private int numberOfParkingSlots;
    private float latitude;
    private float longitude;
    private boolean status;  // Can be "on service" of "offline"
    List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();
    
    public Station(int numberOfParkingSlots, float latitude, float longitude, boolean status) {
    	this.id = generateUniqueID();
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.status = status;
    	this.numberOfParkingSlots = numberOfParkingSlots;
    	List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>(numberOfParkingSlots);
    	parkingSlots = generateAllSlots(parkingSlots);
    }
    
    private int generateUniqueID() {
        return ++numberOfStations;
    }
    
    private List generateAllSlots(List parkingSlots) {
    	for (int cpt = 0; cpt < this.numberOfParkingSlots; cpt++) {
    		ParkingSlot slot = new ParkingSlot();
    		parkingSlots.add(slot);
    	}
    	return parkingSlots;
    }
    
    public int getNumberOfParkingSlots() {
    	return this.numberOfParkingSlots;
    }
    
    public boolean getStatus() {
    	return this.status;
    }
    
    public List getPostition() {
    	List<Float> coords = new ArrayList<Float>(2);
    	coords.add(this.latitude);
    	coords.add(this.longitude);
    	return coords;
    }
    
    
}
