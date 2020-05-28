package core.system;

import core.components.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MyVelibSystem {
    private List<Station> stations;
    private List<User> users;
    private List<Bicycle> bicycles;
    private List<Card> cards;


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

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "MyVelibSystem{" +
                "stations=" + stations +
                ", users=" + users +
                ", bicycles=" + bicycles +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVelibSystem that = (MyVelibSystem) o;
        return Objects.equals(stations, that.stations) &&
                Objects.equals(users, that.users) &&
                Objects.equals(bicycles, that.bicycles) &&
                Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations, users, bicycles, cards);
    }


    public void rentBike(int userID, int StationID) {
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
            if (station.getExistTypeBike(electricalBicycle)) {
                station.getStationTerminal().rentBicycle(electricalBicycle, user, station);
                // Make parking slot free
            } else {
                System.out.println("ERROR ! There are no electrical bicycles!");
            }
        } else {
            Bicycle mechanicalBicycle = new MechanicalBicycle();

            // Ask terminal to rent a bike for the given station
            if (station.getExistTypeBike(mechanicalBicycle)) {
                station.getStationTerminal().rentBicycle(mechanicalBicycle, user, station);
                // Make parking slot free
            } else {
                System.out.println("ERROR ! There are no mechanical bicycles!");
            }
        }


    }


}
