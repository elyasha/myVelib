package core.rides.planning;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import core.components.*;
import core.system.MyVelibSystem;

public class Main {


    public List<Station> getBestStation(Point coordsStart, Point coordsEnd, Bicycle bike) {
        MyVelibSystem system = new MyVelibSystem();
        Point coords;
        double distance;
        double bestDistanceStart = Double.POSITIVE_INFINITY;
        double bestDistanceEnd = Double.POSITIVE_INFINITY;
        Station bestStationStart = null;
        Station bestStationEnd = null;
        List<Station> allStations;
        List<Station> bestStations = new ArrayList<Station>(2);

        allStations = system.getStations();


        for (Station station : allStations) {

            coords = station.getCoordinate();

            // Compute the nearest station for the starting point
            distance = Math.sqrt(Math.pow(coords.getX()- coordsStart.getX(), 2)+Math.pow(coords.getY()- coordsStart.getY(), 2));

            // We want to be sure there exists 'our' bike in the station
            if (distance < bestDistanceStart && station.getExistTypeBike(bike) && station.isOnService()) {
                bestDistanceStart =  distance;
                bestStationStart = station;
            }


            // Compute the nearest station for the ending point
            distance = Math.sqrt(Math.pow(coords.getX()- coordsEnd.getX(), 2)+Math.pow(coords.getY()- coordsEnd.getY(), 2));

            // We want to be sure there exists a free slot in the station
            if (distance < bestDistanceEnd && station.getOneSlotFree() && station.isOnService()) {
                bestDistanceEnd =  distance;
                bestStationEnd = station;
            }

        }
        bestStations.add(bestStationStart);
        bestStations.add(bestStationEnd);

        return bestStations;
    }
}
