package core.components;

import java.sql.Time;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import core.renting.*;

public final class Terminal {

    private boolean onService;
    private int stationID;

    public Terminal() {
        this.onService = false; // It won't work by default
    }

    public Terminal(boolean onService) {
        this.onService = onService;
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
        if (user.isHasBicycle()) {
            System.out.println("You cannot rent another bicycle! Please drop your bicycle first.");
        }
        else {
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
            user.setHasBicycle(true);
            user.setRentStationID(stationID);

            // Change the state of parkingSlot
            ParkingSlot slot = station.getParkingSlotTypeBicycle(bicycle);
            slot.setState(0);
            slot.setBike(null);

        }


    }

    public void dropBicycle(Bicycle bicycle, User user, Station station) {

        // Compute the time of the journey
        double intervalOfTime; // [minutes]
        intervalOfTime = Main.computeRentTime(user);
        Time intervalOfTimeTIME;
        intervalOfTimeTIME = new Time(0, (int) intervalOfTime,0);
        // Compute the rent cost for the user
        double rentCost = Main.getCostWithTimeCredit(bicycle, user.getCard(), intervalOfTimeTIME, user.getTimeCreditBalance(), user);

        // Take the money of the user !!!!
        Main.chargingUser(user, rentCost, station);

        // Changer rentTime
        user.setRentTime(null);

        // Set hasBicycle = true and rentStationID in User
        user.setHasBicycle(false);
        user.setRentStationID(-1); // an impossible id

        // Change the state of parkingSlot
        ParkingSlot slot = station.getParkingSlotTypeBicycle(bicycle);
        slot.setState(1);
        slot.setBike(bicycle);

        // Return bicycle
        System.out.println(user + "You rent is finalized!");


    }

}
