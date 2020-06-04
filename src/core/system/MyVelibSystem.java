package core.system;

import core.components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * The MyVelibSystem class : This class is responsible to implement what a myVelib system (or network) is.
 * It shows how the system will behave, what are its attributes and important methods
 */
public class MyVelibSystem {
    /**
     * The list of stations on the system
     */
    private List<Station> stations;

    /**
     * The list of users on the system
     */
    private List<User> users;

    /**
     * The money that the station has. That is, all the profit of the system
     */
    private double money;

    /**
     * The name of the system or myVelib network
     */
    private String name;


    /**
     * Getter for the stations parameter
     *
     * @return stations
     */
    public List<Station> getStations() {
        return stations;
    }

    /**
     * Setter for the stations parameter
     *
     * @param stations a list of stations
     */
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    /**
     * Getter for the users parameter
     *
     * @return users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Setter for users
     *
     * @param users a list of user objects
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Getter for the money parameter
     *
     * @return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * Setter for money
     *
     * @param money the amount of money that the system will have
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Getter for the name
     *
     * @return name of the system
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the system
     *
     * @param name A string that represents the new name of the system
     */
    public void setName(String name) {
        this.name = name;
    }

    // Constructor


    /**
     * Constructor for the system class
     *
     * @param stations a list of stations
     * @param users    a list of users
     * @param money    an amount of money that the system will have
     */
    public MyVelibSystem(List<Station> stations, List<User> users, double money) {
        this.stations = stations;
        this.users = users;
        this.money = money;
    }

    /**
     * (Simpler) constructor for the system class
     *
     * @param stations a list of stations
     */
    public MyVelibSystem(List<Station> stations) {
        this.stations = stations;
        this.users = new ArrayList<User>();
        this.money = 0;
    }

    /**
     * (Simplest) constructor for the system class, will create an (empty) system
     */
    public MyVelibSystem() {
        this.stations = new ArrayList<Station>();
        this.users = new ArrayList<User>();
        this.money = 0;
    }


    /**
     * toString method
     *
     * @return a string that represents the system
     */
    @Override
    public String toString() {
        return "MyVelibSystem{" +
                "stations=" + stations +
                ", users=" + users +
                '}';
    }

    /**
     * equals method
     *
     * @param o an object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVelibSystem that = (MyVelibSystem) o;
        return Objects.equals(stations, that.stations) &&
                Objects.equals(users, that.users);
    }

    /**
     * hashCode method
     *
     * @return hash(stations, users)
     */
    @Override
    public int hashCode() {
        return Objects.hash(stations, users);
    }


    /**
     * This method is responsible to implement a way to rent a bicycle in the system class. It will ask for the algorithm in the Terminal class
     *
     * @param userID    the user id
     * @param StationID the station id
     */
    public void rentBicycle(int userID, int StationID) {
        Station station = null;
        User user = null;

        // Get station with StationID
        for (Station station_i : stations) {
            if (station_i.getId() == StationID) {
                station = station_i;
                break;
            }
        }

        if (station == null) {
            System.out.println("ERROR ! There is no station with this stationID!");
        }

        // Get user with userID
        for (User user_i : users) {
            if (user_i.getId() == userID) {
                user = user_i;
                break;
            }
        }

        if (user == null) {
            System.out.println("ERROR ! There is no user with this userID!");
        }

        // Ask user for the bicycle type
        // declaring a scanner object for to ask input to the user
        String bicycleType;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the bicycle type (Electrical/Mechanical)");
            bicycleType = scanner.nextLine();
        }
        while ((!bicycleType.equals("Electrical") || !bicycleType.equals("Mechanical")));
        {
            System.out.println("Enter the bicycle type (Electrical/Mechanical)");
            bicycleType = scanner.nextLine();
        }

        // Check bicycle type
        if (bicycleType.equals("Electrical")) {
            Bicycle electricalBicycle = new ElectricalBicycle();

            // Ask terminal to rent a bike for the given station
            if (station.getExistTypeBike(electricalBicycle) && station.isOnService()) {
                station.getStationTerminal().rentBicycle(electricalBicycle, user, station);
                // Make parking slot free
            } else {
                System.out.println("ERROR ! There are no electrical bicycles!");
            }
        } else {
            Bicycle mechanicalBicycle = new MechanicalBicycle();

            // Ask terminal to rent a bike for the given station
            if (station.getExistTypeBike(mechanicalBicycle) && station.isOnService()) {
                station.getStationTerminal().rentBicycle(mechanicalBicycle, user, station);
                // Make parking slot free
            } else {
                System.out.println("ERROR ! There are no mechanical bicycles!");
            }
        }


    }

    /**
     * This methods is responsible for adding money in the system
     *
     * @param money the amount of money to be added
     */
    public void addMoney(double money) {
        this.money += money;
    }

    /**
     * This methods is responsible for removing money from the system
     *
     * @param money the amount of money to be removed
     */
    public void removeMoney(double money) {
        if (this.money - money < 0) {
            System.out.println("ERROR! You don't have the money bro.");
        } else {
            this.money -= money;
        }
    }

    /**
     * This method displays a report for a given user in the system
     *
     * @param user the user that will be studied
     */
    public void displayUserReport(User user) {
        // Check if user is on the system
        if (this.getUsers().contains(user)) {
            System.out.println();
            System.out.println("USER REPORT: " + user.getName());
            System.out.println(user);
            System.out.println();
        }
        // TODO: [No priority] Change a little

    }

    /**
     * This method displays a report for a given station in the system
     *
     * @param station the station
     */
    public void displayStationReport(Station station) {
        if (this.getStations().contains(station)) {
            System.out.println();
            System.out.println("STATION REPORT: " + station.getId());
            System.out.println(station);
            System.out.println();
        }
        // TODO: [No priority] Change a little
    }

    /**
     * This method displays a report for the system (the system itself)
     */
    public void displaySystemReport() {
        System.out.println();
        System.out.println("SYSTEM REPORT: " + this.getName());
        System.out.println(this);
        System.out.println();
        // TODO: [No priority] Change a little
    }


}
