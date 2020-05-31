package core.components;

import java.sql.Time;
import java.time.LocalTime;

import core.renting.*;

public final class Terminal {

    private boolean onService;
    private int stationID;

    public Terminal(int stationID) {
        this.onService = false; // It won't work by default
        this.stationID = stationID;
    }

    public Terminal(boolean onService, int stationID) {
        this.onService = onService;
        this.stationID = stationID;
    }


    // Getters and setters

    public boolean isOnService() {
        return onService;
    }

    public void setOnService(boolean onService) {
        this.onService = onService;
    }


    // Written methods

    public void rentBicycle(Bicycle bicycle, User user, Station station) {
        // Planning checks if there is a bicycle, we don't need to check again

        // A user can only rent 1 bicycle
        if (user.getBicycle() != null) {
            System.out.println("You cannot rent another bicycle! Please drop your bicycle first.");
        } else {
            // If there is a bicycle available
            System.out.println("Here you go!" + user);
            if (bicycle instanceof ElectricalBicycle) {
                System.out.println("A electrical bicycle!");
            } else if (bicycle instanceof MechanicalBicycle) {
                System.out.println("A mechanical bicycle!");
            }

            // Save rentTime
            LocalTime localTime;
            localTime = LocalTime.now();
            user.setRentTime(localTime);

            // Set hasBicycle = true and rentStationID in User
            user.setBicycle(bicycle);
            user.setRentStationID(stationID);
            user.addRenting();

            // Change the state of parkingSlot
            ParkingSlot slot = station.getParkingSlotTypeBicycle(bicycle);
            slot.setState(0);
            slot.setBicycle(null);

        }


    }

    public void dropBicycleWithIntervalOfTime(Bicycle bicycle, User user, Station station, double intervalOfTime) {
        // Compute the time of the journey
//        System.out.println(intervalOfTime);
        Time intervalOfTimeTIME;
        intervalOfTimeTIME = new Time(0, (int) intervalOfTime, 0);
        System.out.println(intervalOfTimeTIME);
        // Compute the rent cost for the user
        double rentCost = Main.getCostWithTimeCredit(bicycle, user.getCard(), intervalOfTimeTIME, user.getTimeCreditBalance(), user);

        // Take the money of the user !!!!
        Main.chargingUser(user, rentCost, station);

        // Add user spent time to the type of bicycle
        if(bicycle instanceof ElectricalBicycle) {
            user.addSpentTimeOnElectricalBicycle(intervalOfTime);
        }
        else if (bicycle instanceof MechanicalBicycle) {
            user.addSpentTimeOnMechanicalBicycle(intervalOfTime);
        }
        else {
            System.out.println("ERROR!");
        }

        // Changer rentTime
        user.setRentTime(null);

        // Set hasBicycle = true and rentStationID in User
        user.setBicycle(null);
        user.setRentStationID(-1); // an impossible id

        // Change the state of parkingSlot
        ParkingSlot slot = station.getParkingSlotTypeBicycle(bicycle);
        slot.setState(1);
        slot.setBicycle(bicycle);

        // Return bicycle
        System.out.println();
        System.out.println(user + "You rent is finalized!");
        System.out.println();
        System.out.println(rentCost);

        station.addNumberOfLocations(1);
    }


    public void dropBicycle(Bicycle bicycle, User user, Station station) {

        // Compute the time of the journey
        double intervalOfTime; // [minutes]
        intervalOfTime = Main.computeRentTime(user);
        System.out.println(intervalOfTime);
        Time intervalOfTimeTIME;
        intervalOfTimeTIME = new Time(0, (int) intervalOfTime, 0);
        System.out.println(intervalOfTimeTIME);
        // Compute the rent cost for the user
        double rentCost = Main.getCostWithTimeCredit(bicycle, user.getCard(), intervalOfTimeTIME, user.getTimeCreditBalance(), user);

        // Take the money of the user !!!!
        Main.chargingUser(user, rentCost, station);

        // Changer rentTime
        user.setRentTime(null);

        // Set hasBicycle = true and rentStationID in User
        user.setBicycle(null);
        user.setRentStationID(-1); // an impossible id

        // Change the state of parkingSlot
        ParkingSlot slot = station.getParkingSlotTypeBicycle(bicycle);
        slot.setState(1);
        slot.setBicycle(bicycle);

        // Return bicycle
        System.out.println();
        System.out.println(user + "You rent is finalized!");
        System.out.println();
        System.out.println(rentCost);

        station.addNumberOfLocations(1);


    }

}
