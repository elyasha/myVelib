package core.components;

import java.sql.Time;
import java.time.LocalTime;

import core.renting.*;

/**
 * The Terminal class : This class defines how terminals are created and how they behave
 */
public final class Terminal {

    /**
     * This parameter is used to know if the terminal is on service or not
     */
    private boolean onService;

    /**
     * The id of the station that has the terminal
     */
    private final int stationID;

    /**
     * A constructor for the Terminal class
     *
     * @param stationID the station id that will have this terminal
     */
    public Terminal(int stationID) {
        this.onService = false; // It won't work by default
        this.stationID = stationID;
    }

    /**
     * A (more complex) constructor for the Terminal class
     *
     * @param onService a boolean to set the initial state of the terminal
     * @param stationID the station id that will have this terminal
     */
    public Terminal(boolean onService, int stationID) {
        this.onService = onService;
        this.stationID = stationID;
    }


    // Getters and setters

    /**
     * a getter for the onService parameter
     *
     * @return onService boolean to see if the station is active or not
     */
    public boolean isOnService() {
        return onService;
    }

    /**
     * setter for the onService parameter
     *
     * @param onService a boolean to be used when setting the terminal's state
     */
    public void setOnService(boolean onService) {
        this.onService = onService;
    }


    // Written methods

    /**
     * The rentBicycle method that implements the renting algorithm for the application
     *
     * @param bicycle a bicycle object (either electrical, or mechanical) that is the type that the user wants
     * @param user    the user object that ask for the renting
     * @param station the station that is used to the renting
     */
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

    /**
     * This method implements the dropping of a bicycle with an interval of time given by the human.
     * It will increment the parameters in the classes that are involved during the dropping process
     *
     * @param bicycle        the bicycle that is being dropped
     * @param user           the user that is dropping
     * @param station        the (end) station, that is to say, the station that the user is dropping the bicycle
     * @param intervalOfTime the interval of time of the location (in minutes)
     */
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
        if (bicycle instanceof ElectricalBicycle) {
            user.addSpentTimeOnElectricalBicycle(intervalOfTime);
        } else if (bicycle instanceof MechanicalBicycle) {
            user.addSpentTimeOnMechanicalBicycle(intervalOfTime);
        } else {
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

        station.addNumberOfDroppings(1);
    }


    /**
     * This methods implements the dropping but without the time interval, because it gets the computer's time.
     *
     * @param bicycle The bicycle that is being dropped
     * @param user    The user that is dropping
     * @param station The station that is receiving the bicycle
     */
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

        station.addNumberOfDroppings(1);


    }

}
