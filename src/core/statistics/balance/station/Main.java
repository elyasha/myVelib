package core.statistics.balance.station;

import core.components.Station;
import core.components.factories.StationFactory;
import core.system.MyVelibSystem;

import java.util.List;

public class Main {

    public static Station getMostUsedStation(MyVelibSystem system) {
        List<Station> stations = system.getStations();
        Station mostUsedStation = null;
        mostUsedStation.setNumberOfLocations(0); // set locations equal to zero

        for (Station station : stations
        ) {
            // Check to see if station has a higher numberOfLocations
            if (station.getNumberOfLocations() > mostUsedStation.getNumberOfLocations()) {
                mostUsedStation = station;
            }
        }


        return mostUsedStation;
    }

    public static Station getLeastOccupiedStation(MyVelibSystem system) {
        List<Station> stations = system.getStations();
        Station leastOccupiedStation = null;

        // We are going to see how many free slots there are in the station and compare them


        return leastOccupiedStation;
    }

    public static void stationBalance(MyVelibSystem system) {
        // Calculate de average station balance

        // Calculate the average of all station money

        // Calculate the station that gained the most in the myVelib system

        // Calculate the station that gained the least in the myVelib system

        // Calculate other stuff
    }
}
