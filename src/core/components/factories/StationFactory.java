package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;

public class StationFactory {
    // TODO: Create a test to check if there is already a station when creating one

    public static Station addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots, money, numberOfLocations);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    public static Station addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    public static Station addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
        StandardStation station = new StandardStation(coordinate, onService, parkingSlots, money, numberOfLocations);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    public static Station addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        StandardStation station = new StandardStation(coordinate, onService, parkingSlots);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);

        return station;
    }

}
