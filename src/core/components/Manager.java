package core.components;

import core.system.MyVelibSystem;

import java.awt.*;

/**
 * The Manager class: This class implements the manager object
 * it will have access to all information on all systems in the core/CLI applications
 */
public class Manager extends User {

    /**
     * The Manager constructor: It defines how we can instantiate the Manager class
     *
     * @param name             The name of the manager
     * @param coordinate       The coordinate that the manager will be inserted
     * @param creditCardNumber The credit card number of the manager
     * @param money            The amount of money that the manager will have in the beginning of the application
     */
    public Manager(String name, Point coordinate, int creditCardNumber, double money) {
        super(name, coordinate, creditCardNumber, money);
    }

    /**
     * This is the method that allows the manager to see his current status (toString method)
     *
     * @return the manager toString
     */
    public String seeMyStatus() {
        System.out.println(this);
        return this.toString();
    }

    /**
     * This is the method that allows the manager to see the current status of a giver user in a given system
     *
     * @param system The MyVelibSystem that the user is in
     * @param userID The user id
     */
    public String seeCurrentStatus(MyVelibSystem system, int userID) {
        User currentUser = null;

        for (User user : system.getUsers()) {
            if (user.getId() == userID) {
                currentUser = user;
                break;
            }
        }

        if (currentUser == null) {
            System.out.println("This user is not in the system!");
        } else {
            System.out.println(currentUser);
        }

        assert currentUser != null;
        return currentUser.toString();


    }

    /**
     * This method allows the manager to see the current state of a given station on a give system
     *
     * @param system    the system that the station is supposed to be
     * @param stationID the station id
     */
    public String seeCurrentStationState(MyVelibSystem system, int stationID) {
        // Manager can see all systems
        System.out.println();
        Station currentStation = null;
        // Check to see if the station exists
        for (Station station : system.getStations()
        ) {
            if (station.getId() == stationID) {
                currentStation = station;
                break;
            }
        }

        if (currentStation == null) {
            System.out.println("The station does not exist in our system!");
        } else {
            System.out.println();
            System.out.println("STATION REPORT");
            System.out.println(currentStation);
            System.out.println();
        }

        assert currentStation != null;
        return currentStation.toString();


    }

    /**
     * This method allows the manager to see a report for a given system
     *
     * @param system the system that will be studied
     */
    public String displaySystemReport(MyVelibSystem system) {
        // Manager can see all systems
        System.out.println();
        System.out.println("SYSTEM REPORT");
        System.out.println(system);
        System.out.println();

        return system.toString();
    }
}
