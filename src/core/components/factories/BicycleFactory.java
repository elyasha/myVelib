package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

/**
 * The BicycleFactory class : This is the factory to create and add new bicycles, either electrical or mechanical
 * It is uses the simple factory design pattern
 */
public class BicycleFactory {

    /**
     * This method is responsible for creating an electrical bicycle given a station and a system
     *
     * @param system  the system
     * @param station the station
     */
    public static void addElectricalBicycle(MyVelibSystem system, Station station) {

        // Check the station (parkingSlot available)
        ParkingSlot freeSlot = station.getOneFreeSlot();
        if (freeSlot != null) {
            // Creating the bicycle
            ElectricalBicycle bicycle = new ElectricalBicycle();

            // Add to station
            freeSlot.setState(1);
            freeSlot.setBicycle(bicycle);
        } else {
            System.out.println("There is no available slot");
        }


    }

    /**
     * This method is responsible for creating an electrical bicycle (just an instance).
     * It is important in some packages of the project
     *
     * @return the new electrical bicycle instance
     */
    public static Bicycle createElectricalBicycle() {
        return new ElectricalBicycle();
    }

    /**
     * This method is responsible for creating a mechanical bicycle given a station and a system
     *
     * @param system  the system
     * @param station the station
     */
    public static void addMechanicalBicycle(MyVelibSystem system, Station station) {
        // Check the station (parkingSlot available)
        ParkingSlot freeSlot = station.getOneFreeSlot();
        if (freeSlot != null) {
            // Creating the bicycle
            MechanicalBicycle bicycle = new MechanicalBicycle();

            // Add to station
            freeSlot.setState(1);
            freeSlot.setBicycle(bicycle);
        } else {
            System.out.println("There is no available slot");
        }
    }

    /**
     * This method is responsible for creating a mechanical bicycle (just an instance).
     * It is important in some packages of the project
     *
     * @return the new mechanical bicycle instance
     */
    public static Bicycle createMechanicalBicycle() {
        return new MechanicalBicycle();
    }
}
