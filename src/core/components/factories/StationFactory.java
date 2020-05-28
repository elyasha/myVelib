package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;

public class StationFactory {

    public void addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots, money, numberOfLocations);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);
    }

    public void addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);
    }

    public void addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
        StandardStation station = new StandardStation(coordinate, onService, parkingSlots, money, numberOfLocations);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);
    }

    public void addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        StandardStation station = new StandardStation(coordinate, onService, parkingSlots);
        List<Station> stations = system.getStations();
        stations.add(station);
        system.setStations(stations);
    }

}
