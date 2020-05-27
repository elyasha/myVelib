package core.components;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Station {
    private final int id = generateUniqueID();
    private static int numberOfStations = 0;
    private Point coordinate;
    private boolean onService;  // Can be "on service" (true) of "offline" (false)
    private List<ParkingSlot> parkingSlots;
    private Terminal terminal;

    private int generateUniqueID() {
        return ++numberOfStations;
    }

    // Getters and setters

    public int getId() {
        return this.id;
    }

    public boolean isOnService() {
        return onService;
    }

    public void setOnService(boolean onService) {
        this.onService = onService;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public Terminal getStationTerminal() {
        return terminal;
    }

    public static int getNumberOfStations() {
        return numberOfStations;
    }

    // Written methods

    private List<ParkingSlot> generateAllSlots(List<ParkingSlot> parkingSlots) {
        for (int cpt = 0; cpt < this.parkingSlots.size(); cpt++) {
            ParkingSlot slot = new ParkingSlot();
            parkingSlots.add(slot);
        }
        return parkingSlots;
    }

    public boolean GetExistTypeBike(Bicycle bike) {
    	for(ParkingSlot slot: parkingSlots) {
    		if (slot.getTypeBike()==bike) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean GetOneSlotFree() {
    	for(ParkingSlot slot: parkingSlots) {
    		if (slot.getState() == 0) {
    			return true;
    		}
    	}
    	return false;
    }
    
}
