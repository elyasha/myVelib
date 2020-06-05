package core.rides.planning;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import core.components.*;
import core.system.MyVelibSystem;

/**
 * The PlanningApp class of rides.planning module : This class contains all algorithms that are needed to plan a ride given two points.
 * This class is used by any user when he needs to plan a ride. It will return, in general, the stationID.
 */
public class PlanningApp {

    /**
     * Compute the best start and end station according to the least start and end distances strategy.
     *
     * @param system:      system the user is using
     * @param coordsStart: where the user wants to start the location
     * @param coordsEnd:   where the user wants to stop the location
     * @param bicycle:     the bicycle the user want to rent
     * @return best start and end stations
     */
    public static List<Station> getBestStation(MyVelibSystem system, Point coordsStart, Point coordsEnd, Bicycle bicycle) {
        Point coords;
        double distance;
        double bestDistanceStart = Double.POSITIVE_INFINITY;
        double bestDistanceEnd = Double.POSITIVE_INFINITY;
        Station bestStationStart = null;
        Station bestStationEnd = null;
        List<Station> allStations = system.getStations();
        List<Station> bestStations = new ArrayList<>(2);


        for (Station station : allStations) {

            coords = station.getCoordinate();

            // Compute the nearest station for the starting point
            distance = Math.sqrt(Math.pow(coords.getX() - coordsStart.getX(), 2) + Math.pow(coords.getY() - coordsStart.getY(), 2));

//            System.out.println();
//            List<ParkingSlot> parkSlots = station.getParkingSlots();
//            for (ParkingSlot slot: parkSlots
//                 ) {
////                System.out.println(slot.getBicycle() instanceof MechanicalBicycle);
////                System.out.println();
//            }

//            System.out.println(station.getParkingSlots());
            // We want to be sure there exists 'our' bike in the station
//            System.out.println();
//            System.out.println(station.getExistTypeBike(bicycle));
//            System.out.println(station.isOnService());
//            System.out.println();
            if (distance < bestDistanceStart && station.getExistTypeBike(bicycle) && station.isOnService()) {
                bestDistanceStart = distance;
                bestStationStart = station;

            }


            // Compute the nearest station for the ending point
            distance = Math.sqrt(Math.pow(coords.getX() - coordsEnd.getX(), 2) + Math.pow(coords.getY() - coordsEnd.getY(), 2));

            // We want to be sure there exists a free slot in the station
            if (distance < bestDistanceEnd && station.hasOneSlotFree() && station.isOnService()) {
                bestDistanceEnd = distance;
                bestStationEnd = station;
            }

//            System.out.println(bestDistanceStart);
//            System.out.println(bestStationStart);
//            System.out.println("=====================");
//            System.out.println(bestDistanceEnd);
//            System.out.println(bestStationEnd);
//            System.out.println();

        }
        bestStations.add(bestStationStart);
        bestStations.add(bestStationEnd);

        return bestStations;
    }
}
