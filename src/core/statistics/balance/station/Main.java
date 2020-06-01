package core.statistics.balance.station;

import core.components.SortStationByMostUsed;
import core.components.Station;
import core.system.MyVelibSystem;

import java.util.Collections;
import java.util.List;

/**
 *  The Main class in statistics.balance.station : This class has all the algorithms and methods that we need to calculate the statistics
 *  in the application for stations, that is to say, plus stations and standard stations.
 */
public class Main {

    /**
     * Getter of the most used station
     * @param system
     * @return
     */
    public static Station getMostUsedStation(MyVelibSystem system) {
        Station mostUsedStation = system.getStations().get(0); // Take the first station on the system

        for (Station station : system.getStations()
        ) {
            // Check to see if station has a higher numberOfLocations
            if (station.getNumberOfDroppings() > mostUsedStation.getNumberOfDroppings()) {
                mostUsedStation = station;
            }
        }


        return mostUsedStation;
    }

    public static Station getLeastOccupiedStation(MyVelibSystem system) {
        Station leastOccupiedStation = system.getStations().get(0); // Take the first station

        // We are going to see how many free slots there are in the station and compare them
        // TODO: Design method

        return leastOccupiedStation;
    }


    public static void stationBalance(MyVelibSystem system) {
        // Calculate the average station balance
        double averageStationBalance = 0; // Initialize the average to zero

        for (Station station : system.getStations()
        ) {
            averageStationBalance += station.getMoney();
        }

        averageStationBalance /= system.getStations().size();

        System.out.println("The average station balance is: " + averageStationBalance + "!");
        System.out.println();


        // Calculate the average of all station money // ????

        // Calculate the station that gained the most in the myVelib system
        Station stationWhoGainedTheMost = system.getStations().get(0); // Take the first

        for (Station station : system.getStations()
        ) {
            if (station.getMoney() > stationWhoGainedTheMost.getMoney()) {
                stationWhoGainedTheMost = station;
            }
        }

        System.out.println("The station who gained the most is: " + stationWhoGainedTheMost + "!");
        System.out.println();


        // Calculate the station that gained the least in the myVelib system
        Station stationWhoGainedTheLeast = system.getStations().get(0); // Take the first

        for (Station station : system.getStations()
        ) {
            if (station.getMoney() < stationWhoGainedTheLeast.getMoney()) {
                stationWhoGainedTheLeast = station;
            }
        }

        System.out.println("The station who gained the least is: " + stationWhoGainedTheLeast + "!");
        System.out.println();

        // Calculate other stuff

        // TODO: (Charlito) See if we can add more stuff here and maybe refactor the methods

    }

    public static int getNumberOfRentings(Station station) {
        return station.getNumberOfRentings();
    }

    public static int getNumberOfDroppings(Station station) {
        return station.getNumberOfDroppings();
    }

    public static double computeAverageRateOfOccupation(Station station) {
        // TODO: Design method
        return 0;
    }

    public static List<Station> sortStationByMostUsed(List<Station> stations) {

        SortStationByMostUsed mostUsedComparator = new SortStationByMostUsed();
        Collections.sort(stations, mostUsedComparator);

        return stations;
    }

    public static void sortStationByLeastOccupied(List<Station> stations) {
        // TODO
    }
}
