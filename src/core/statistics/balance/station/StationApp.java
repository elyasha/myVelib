package core.statistics.balance.station;

import core.components.SortStationByMostUsed;
import core.components.Station;
import core.system.MyVelibSystem;

import java.util.Collections;
import java.util.List;

/**
 * The StationApp class in statistics.balance.station : This class has all the algorithms and methods that we need to calculate the statistics
 * in the application for stations, that is to say, plus stations and standard stations.
 */
public class StationApp {

    /**
     * Getter of the most used station of a give system
     *
     * @param system the system that is being studied
     * @return the station that has is most used (the number of droppings is used to compare). Return the first one, if there are more
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

    /**
     * Getter for the least occupied station
     *
     * @param system the system that is being studied
     * @return the station that is least used (the rate of occupation is used). Return the first one, if there are more
     */
    public static Station getLeastOccupiedStation(MyVelibSystem system) {
        Station leastOccupiedStation = system.getStations().get(0); // Take the first station

        // We are going to see how many free slots there are in the station and compare them
        // TODO: Design method

        return leastOccupiedStation;
    }


    /**
     * This method is used to get the station balance, it is used to compute many different parameters
     * parameter 1 : average station balance on the system
     * parameter 2 : the station which gained the most in the system
     * parameter 3 : the station which gained the least in the system
     *
     * @param system the system that will be studied
     */
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

    }

    /**
     * Getter for the number of rentings
     *
     * @param station The station that will be studied
     * @return an integer that represents the number of rentings
     */
    public static int getNumberOfRentings(Station station) {
        return station.getNumberOfRentings();
    }

    /**
     * Getter for the number of droppings
     *
     * @param station The station that will be studied
     * @return an integer that represents the number of droppings
     */
    public static int getNumberOfDroppings(Station station) {
        return station.getNumberOfDroppings();
    }

    /**
     * This methods is used to compute the average rate of occupation of a given station
     *
     * @param station the station that is being studied
     * @return a double that represents the average rate of occupation of a given station
     */
    public static double computeAverageRateOfOccupation(Station station) {
        // TODO: Design method
        return 0;
    }

    /**
     * This method is used to sort a list of station by the most used policy
     *
     * @param stations the list of stations that is being used
     * @return the list sorted
     */
    public static List<Station> sortStationByMostUsed(List<Station> stations) {

        SortStationByMostUsed mostUsedComparator = new SortStationByMostUsed();
        Collections.sort(stations, mostUsedComparator);

        return stations;
    }

    /**
     * This method is used to sort a list of station by the least occupied policy
     *
     * @param stations the list of stations that is being used
     */
    public static void sortStationByLeastOccupied(List<Station> stations) {
        // TODO: Design method
    }
}
