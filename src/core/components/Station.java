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
    private int numberOfLocations;

    private int generateUniqueID() {
        return ++numberOfStations;
    }

    // Constructor

    public Station(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
        this.coordinate = coordinate;
        this.onService = onService;
        this.parkingSlots = parkingSlots;
        this.terminal = new Terminal(onService, this.id);
        this.money = money;
        this.numberOfLocations = numberOfLocations;
    }

    public Station(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        this.coordinate = coordinate;
        this.onService = onService;
        this.parkingSlots = parkingSlots;
        this.terminal = new Terminal(onService, this.id);
        this.money = 0;
        this.numberOfLocations = 0;
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

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    // Written methods

    private List<ParkingSlot> generateAllSlots(List<ParkingSlot> parkingSlots) {
        for (int cpt = 0; cpt < this.parkingSlots.size(); cpt++) {
            ParkingSlot slot = new ParkingSlot();
            parkingSlots.add(slot);
        }
        return parkingSlots;
    }

    public boolean getExistTypeBike(Bicycle bicycle) {
        if (bicycle instanceof ElectricalBicycle) {
            return hasAvailableElectricalBicycle();
        }
        else if (bicycle instanceof MechanicalBicycle) {
            return hasAvailableMechanicalBicycle();
        }
        else {
            return false;
        }

    }

    public boolean hasAvailableElectricalBicycle() {
        for(ParkingSlot slot: parkingSlots) {
            System.out.println(slot.getBicycle());
            if (slot.getBicycle() instanceof ElectricalBicycle) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAvailableMechanicalBicycle() {
        for(ParkingSlot slot: parkingSlots) {
            System.out.println(slot.getBicycle());
            if (slot.getBicycle() instanceof MechanicalBicycle) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasOneSlotFree() {
    	for(ParkingSlot slot: parkingSlots) {
    		if (slot.getState() == 0) {
    			return true;
    		}
    	}
    	return false;
    }

    public ParkingSlot getOneFreeSlot() {
        for (ParkingSlot slot: parkingSlots
             ) {
            if (slot.getState() == 0) {
                return slot;
            }
        }
        return null;
    }


    public ParkingSlot getParkingSlotTypeBicycle(Bicycle bicycle) {
        ParkingSlot slot;
        if (bicycle instanceof ElectricalBicycle) {
            slot = getElectricalParkingSlot();
        }
        else if (bicycle instanceof MechanicalBicycle) {
            slot = getMechanicalParkingSlot();
        }
        else {
            slot = null;
        }

        return slot;
    }

    public ParkingSlot getElectricalParkingSlot() {
        ParkingSlot slot = null;
        for(ParkingSlot slot_i: parkingSlots) {
            if (slot_i.getBicycle() instanceof  ElectricalBicycle) {
                slot = slot_i;
                break;
            }
        }
        return slot;
    }

    public ParkingSlot getMechanicalParkingSlot() {
        ParkingSlot slot = null;
        for(ParkingSlot slot_i: parkingSlots) {
            if (slot_i.getBicycle() instanceof  MechanicalBicycle) {
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

    public void addNumberOfLocations(int number) {
        this.numberOfLocations += number;
    }
    
}
