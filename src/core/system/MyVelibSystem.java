package core.system;

import core.components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MyVelibSystem {
    private List<Station> stations;
    private List<User> users;
    private double money;
    private String name;


    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor


    public MyVelibSystem(List<Station> stations, List<User> users, double money) {
        this.stations = stations;
        this.users = users;
        this.money = money;
    }

    public MyVelibSystem(List<Station> stations) {
        this.stations = stations;
        this.users = new ArrayList<User>();
        this.money = 0;
    }

    public MyVelibSystem() {
        this.stations = new ArrayList<Station>();
        this.users = new ArrayList<User>();
        this.money = 0;
    }


    @Override
    public String toString() {
        return "MyVelibSystem{" +
                "stations=" + stations +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVelibSystem that = (MyVelibSystem) o;
        return Objects.equals(stations, that.stations) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations, users);
    }


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

    public void displayUserReport(User user) {
        // Check if user is on the system
        if (this.getUsers().contains(user)) {
            System.out.println();
            System.out.println("USER REPORT: " + user);
            System.out.println(user);
            System.out.println();
        }
        // TODO: [No priority] Change a little

    }

    public void displayStationReport(Station station) {
        if (this.getStations().contains(station)) {
            System.out.println();
            System.out.println("STATION REPORT: " + station);
            System.out.println(station);
            System.out.println();
        }
        // TODO: [No priority] Change a little
    }

    public void displaySystemReport() {
        System.out.println();
        System.out.println("SYSTEM REPORT: " + this);
        System.out.println(this);
        System.out.println();
        // TODO: [No priority] Change a little
    }


}
