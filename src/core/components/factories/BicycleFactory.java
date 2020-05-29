package core.components.factories;

import core.components.ElectricalBicycle;
import core.components.MechanicalBicycle;
import core.components.ParkingSlot;
import core.components.Station;
import core.system.MyVelibSystem;

public class BicycleFactory {

    public void addElectricalBicycle(MyVelibSystem system, Station station) {

        // Check the station (parkingSlot available)
        ParkingSlot freeSlot = station.getOneFreeSlot();
        if (freeSlot != null) {
            // Creating the bicycle
            ElectricalBicycle bicycle = new ElectricalBicycle();

            // Add to station
            freeSlot.setState(1);
            freeSlot.setBike(bicycle);
        } else {
            System.out.println("There is no available slot!");
        }


    }

    public void addMechanicalBicycle(MyVelibSystem system, Station station) {
        // Check the station (parkingSlot available)
        ParkingSlot freeSlot = station.getOneFreeSlot();
        if (freeSlot != null) {
            // Creating the bicycle
            MechanicalBicycle bicycle = new MechanicalBicycle();

            // Add to station
            freeSlot.setState(1);
            freeSlot.setBike(bicycle);
        } else {
            System.out.println("There is no available slot!");
        }
    }
}
