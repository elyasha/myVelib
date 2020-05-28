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
    private double money;

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
        this.terminal.setOnService(onService);
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    // Written methods

    private List<ParkingSlot> generateAllSlots(List<ParkingSlot> parkingSlots) {
        for (int cpt = 0; cpt < this.parkingSlots.size(); cpt++) {
            ParkingSlot slot = new ParkingSlot();
            parkingSlots.add(slot);
        }
        return parkingSlots;
    }

    public boolean getExistTypeBike(Bicycle bike) {
    	for(ParkingSlot slot: parkingSlots) {
    		if (slot.getTypeBike()==bike) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean getOneSlotFree() {
    	for(ParkingSlot slot: parkingSlots) {
    		if (slot.getState() == 0) {
    			return true;
    		}
    	}
    	return false;
    }


    public ParkingSlot getParkingSlotTypeBicycle(Bicycle bike) {
        ParkingSlot slot = null;
        for(ParkingSlot slot_i: parkingSlots) {
            if (slot_i.getTypeBike()==bike) {
                slot = slot_i;
                break;
            }
        }
        return slot;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void removeMoney(double money) {
        if (this.money - money < 0) {
            System.out.println("ERROR! You don't have the money bro.");
        } else {
            this.money -= money;
        }
    }
    
}
