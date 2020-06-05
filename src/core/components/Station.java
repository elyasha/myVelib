package core.components;

import core.components.factories.ParkingSlotsFactory;

import java.awt.*;
import java.util.List;
import java.util.Objects;

/**
 * The Station class : This class defines what stations are and how they behave
 */
public abstract class Station {

    /**
     * The unique id of the station
     */
    private final int id = generateUniqueID();

    /**
     * The number of stations in the application
     */
    private static int numberOfStations = 0;

    /**
     * The coordinate of the station
     */
    private Point coordinate;

    /**
     * The onService parameter
     * <p>
     * if true, the station is on service
     * if false, the station is not on service
     */
    private boolean onService;  // Can be "on service" (true) of "offline" (false)

    /**
     * A list of parking slots that is in the station
     */
    private List<ParkingSlot> parkingSlots;

    /**
     * The terminal of the station, it is used by the users to rent or drop bicycles
     */
    private final Terminal terminal;

    /**
     * The amount of money that the user has in the application
     */
    private double money;

    /**
     * The number of droppings (that is to say, the number of times that a bicycle was dropped in the station)
     */
    private int numberOfDroppings;

    /**
     * The number of rentings (that is to say, the number of times that a bicycle was rented)
     */
    private int numberOfRentings;


    /**
     * This method generate an unique id
     *
     * @return the unique id
     */
    private int generateUniqueID() {
        return ++numberOfStations;
    }

    // Constructors

    /**
     * A Station constructor
     *
     * @param coordinate        coordinate that will be used to place a plus station
     * @param onService         a boolean parameter to know if the station will be on service
     * @param parkingSlots      a list of parking slots that will populate the plus station
     * @param money             the initial money that the station will have
     * @param numberOfDroppings the number of droppings (or locations)
     */
    public Station(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfDroppings) {
        this.coordinate = coordinate;
        this.onService = onService;
        this.parkingSlots = parkingSlots;
        this.terminal = new Terminal(onService, this.id);
        this.money = money;
        this.numberOfDroppings = numberOfDroppings;
    }

    /**
     * A (simpler) Station constructor
     *
     * @param coordinate   coordinate that will be used to place a plus station
     * @param onService    a boolean parameter to know if the station will be on service
     * @param parkingSlots a list of parking slots that will populate the plus station
     */
    public Station(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        this.coordinate = coordinate;
        this.onService = onService;
        this.parkingSlots = parkingSlots;
        this.terminal = new Terminal(onService, this.id); // TODO: Create a TerminalFactory
        this.money = 0; // the initial money of the station is zero
        this.numberOfDroppings = 0; // the number of droppings is set to zero
    }

    // Getters and setters

    /**
     * getter for id
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * getter for onService parameter
     *
     * @return onService parameter
     */
    public boolean isOnService() {
        return onService;
    }

    /**
     * setter for onService parameter
     *
     * @param onService a boolean that will be used to set onService parameter
     */
    public void setOnService(boolean onService) {
        this.onService = onService;
        this.terminal.setOnService(onService);
    }

    /**
     * getter for coordinate
     *
     * @return coordinate
     */
    public Point getCoordinate() {
        return coordinate;
    }

    /**
     * setter for coordinate (maybe the relevance of this method could be discussed)
     *
     * @param coordinate coordinate that will be used to set the station coordinate
     */
    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * getter for the list of parking slots
     *
     * @return parkingSlots (a list of parking slots)
     */
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    /**
     * setter for parkingSlots
     *
     * @param parkingSlots a list of parking slots
     */
    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    /**
     * getter for the terminal of the station
     *
     * @return the terminal object
     */
    public Terminal getStationTerminal() {
        return terminal;
    }

    /**
     * getter for the number of stations
     *
     * @return number of stations in the application
     */
    public static int getNumberOfStations() {
        return numberOfStations;
    }

    /**
     * getter for the money parameter
     *
     * @return the total amount of money that stations has (it can be used to see the station profit)
     */
    public double getMoney() {
        return money;
    }

    /**
     * setter for the money parameter
     *
     * @param money the total amount of money that the station has
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * getter for the number of droppings (or complete locations)
     *
     * @return the number of droppings
     */
    public int getNumberOfDroppings() {
        return numberOfDroppings;
    }

    /**
     * setter for the number of droppings
     *
     * @param numberOfDroppings the number of complete locations (or droppings)
     */
    public void setNumberOfDroppings(int numberOfDroppings) {
        this.numberOfDroppings = numberOfDroppings;
    }

    /**
     * getter for the number of rentings
     *
     * @return the number of rentings
     */
    public int getNumberOfRentings() {
        return numberOfRentings;
    }

    /**
     * setter for the number of rentings
     *
     * @param numberOfRentings the number of rentings to be used in the setting process
     */
    public void setNumberOfRentings(int numberOfRentings) {
        this.numberOfRentings = numberOfRentings;
    }

    /**
     * toString method for Station
     *
     * @return a string that represents the station
     */
    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", coordinate=" + coordinate +
                ", onService=" + onService +
                ", parkingSlots=" + parkingSlots +
                ", terminal=" + terminal +
                ", money=" + money +
                ", numberOfDroppings=" + numberOfDroppings +
                ", numberOfRentings=" + numberOfRentings +
                '}';
    }

    /**
     * equals method for Station
     *
     * @param o an object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return id == station.id &&
                onService == station.onService &&
                Double.compare(station.money, money) == 0 &&
                numberOfDroppings == station.numberOfDroppings &&
                numberOfRentings == station.numberOfRentings &&
                Objects.equals(coordinate, station.coordinate) &&
                Objects.equals(parkingSlots, station.parkingSlots) &&
                Objects.equals(terminal, station.terminal);
    }

    /**
     * hashCode method for Station
     *
     * @return hash(id, coordinate, onService, parkingSlots, terminal, money, numberOfDroppings, numberOfRentings)
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, coordinate, onService, parkingSlots, terminal, money, numberOfDroppings, numberOfRentings);
    }


    // Written methods

    /**
     * This method generates free parking slots and return all the parking slots (with memory allocation)
     *
     * @param parkingSlots a list of parking slots (that may be empty)
     * @return a complete list of parking slots (that has memory allocation)
     */
    private List<ParkingSlot> generateAllSlots(List<ParkingSlot> parkingSlots) {
        for (int cpt = 0; cpt < this.parkingSlots.size(); cpt++) {
            ParkingSlot slot = ParkingSlotsFactory.createFreeParkingSlot();
            parkingSlots.add(slot);
        }
        return parkingSlots;
    }

    /**
     * This method will return a boolean that represents the existence or not of give bicycle type
     *
     * @param bicycle a bicycle object, either electrical or mechanical bicycle
     * @return true, if the station has a bicycle of the same type. false, otherwise
     */
    public boolean getExistTypeBike(Bicycle bicycle) {
        if (bicycle instanceof ElectricalBicycle) {
            return hasAvailableElectricalBicycle();
        } else if (bicycle instanceof MechanicalBicycle) {
            return hasAvailableMechanicalBicycle();
        } else {
            return false;
        }

    }

    /**
     * This method is used to see if a station has an available electrical bicycle to be rented
     *
     * @return true, if the station has an available electrical bicycle. false, otherwise
     */
    public boolean hasAvailableElectricalBicycle() {
        for (ParkingSlot slot : parkingSlots) {
//            System.out.println(slot.getBicycle());
            if (slot.getBicycle() instanceof ElectricalBicycle) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to see if a station has an available mechanical bicycle to be rented
     *
     * @return true, if the station has an available mechanical bicycle. false, otherwise
     */
    public boolean hasAvailableMechanicalBicycle() {
        for (ParkingSlot slot : parkingSlots) {
//            System.out.println(slot.getBicycle());
            if (slot.getBicycle() instanceof MechanicalBicycle) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if a station has a free slot
     *
     * @return true, if the station has a free slot. false, otherwise
     */
    public boolean hasOneSlotFree() {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getState() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is a getter for a free slot. If it has not a free slot, it returns null
     *
     * @return a free slot if the station has any. null, otherwise
     */
    public ParkingSlot getOneFreeSlot() {
        for (ParkingSlot slot : parkingSlots
        ) {
            if (slot.getState() == 0) {
                return slot;
            }
        }
        return null;
    }


    /**
     * This method gets a parking slot for the type of bicycle that is passed as argument
     *
     * @param bicycle any bicycle in the application (can be electrical or mechanical)
     * @return a slot of the give bicycle if there is any. null, otherwise
     */
    public ParkingSlot getParkingSlotTypeBicycle(Bicycle bicycle) {
        ParkingSlot slot;
        if (bicycle instanceof ElectricalBicycle) {
            slot = getElectricalParkingSlot();
        } else if (bicycle instanceof MechanicalBicycle) {
            slot = getMechanicalParkingSlot();
        } else {
            slot = null;
        }

        return slot;
    }

    /**
     * This method get an electrical parking slot (that is a parking slot that has an electrical bicycle) if there is any
     *
     * @return an electrical parking slot if there is any in the station. null, otherwise
     */
    public ParkingSlot getElectricalParkingSlot() {
        ParkingSlot slot = null;
        for (ParkingSlot slot_i : parkingSlots) {
            if (slot_i.getBicycle() instanceof ElectricalBicycle) {
                slot = slot_i;
                break;
            }
        }
        return slot;
    }

    /**
     * This method get a mechanical parking slot (that is a parking slot that has an mechanical bicycle) if there is any
     *
     * @return a mechanical parking slot if there is any in the station. null, otherwise
     */
    public ParkingSlot getMechanicalParkingSlot() {
        ParkingSlot slot = null;
        for (ParkingSlot slot_i : parkingSlots) {
            if (slot_i.getBicycle() instanceof MechanicalBicycle) {
                slot = slot_i;
                break;
            }
        }
        return slot;
    }

    /**
     * This methods adds money in the station
     *
     * @param money The amount of money to be added to the station
     */
    public void addMoney(double money) {
        this.money += money;
    }

    /**
     * This methods removes money in the station
     *
     * @param money The amount of money to be removed from the station
     */
    public void removeMoney(double money) {
        if (this.money - money < 0) {
            System.out.println("ERROR! You don't have the money bro.");
        } else {
            this.money -= money;
        }
    }

    /**
     * This methods adds the number of droppings
     *
     * @param number The number that will be used to increase the number of droppings
     */
    public void addNumberOfDroppings(int number) {
        this.numberOfDroppings += number;
    }

    /**
     * This methods adds the number of rentings
     *
     * @param number The number that will be used to increase the number of rentings
     */
    public void addNumberOfRentings(int number) {
        this.numberOfRentings += number;
    }
}
