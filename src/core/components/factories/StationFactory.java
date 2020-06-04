package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;

/**
 * The StationFactory class : This is the factory to create and add new station to a give system. It can add plus or standard stations.
 * It is uses the simple factory design pattern
 */
public class StationFactory {

    /**
     * This method creates a plus station and add it to a given system.
     *
     * @param system            the system that will have the new station
     * @param coordinate        the coordinate of the station
     * @param onService         the onService boolean
     * @param parkingSlots      a list of parking slots
     * @param money             the initial money of the station
     * @param numberOfDroppings the (initial) number of droppings
     * @return the PlusStation instance
     */
    public static Station addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfDroppings) {
        List<Station> stations = system.getStations();
        for (Station station : stations) {
            Point coordStation = station.getCoordinate();
            if (coordinate.equals(coordStation)) {
                // we cannot create a station that already exists
                return null;
            }
        }
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots, money, numberOfDroppings);
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    /**
     * This method creates a plus station and add it to a given system with fewer arguments. It can be simpler in some cases.
     *
     * @param system       the system that will have the new station
     * @param coordinate   the coordinate of the station
     * @param onService    the onService boolean
     * @param parkingSlots a list of parking slots
     * @return the PlusStation instance
     */
    public static Station addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        List<Station> stations = system.getStations();
        for (Station station : stations) {
            Point coordStation = station.getCoordinate();
            if (coordinate.equals(coordStation)) {
                // we cannot create a station that already exists
                return null;
            }
        }
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots);
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    /**
     * This method creates a standard station and add it to a given system.
     *
     * @param system            the system that will have the new station
     * @param coordinate        the coordinate of the station
     * @param onService         the onService boolean
     * @param parkingSlots      a list of parking slots
     * @param money             the initial money of the station
     * @param numberOfDroppings the (initial) number of droppings
     * @return the StandardStation instance
     */
    public static Station addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfDroppings) {
        List<Station> stations = system.getStations();
        for (Station station : stations) {
            Point coordStation = station.getCoordinate();
            if (coordinate.equals(coordStation)) {
                // we cannot create a station that already exists
                return null;
            }
        }
        StandardStation station = new StandardStation(coordinate, onService, parkingSlots, money, numberOfDroppings);

        stations.add(station);
        system.setStations(stations);

        return station;
    }

    /**
     * This method creates a standard station and add it to a given system with fewer arguments. It can be simpler in some cases.
     *
     * @param system       the system that will have the new station
     * @param coordinate   the coordinate of the station
     * @param onService    the onService boolean
     * @param parkingSlots a list of parking slots
     * @return the StandardStation instance
     */
    public static Station addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        List<Station> stations = system.getStations();
        for (Station station : stations) {
            Point coordStation = station.getCoordinate();
            if (coordinate.equals(coordStation)) {
                // we cannot create a station that already exists
                return null;
            }
        }
        StandardStation station = new StandardStation(coordinate, onService, parkingSlots);
        stations.add(station);
        system.setStations(stations);

        return station;
    }

}
