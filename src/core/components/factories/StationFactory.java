package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;

public class StationFactory {
   
    public static Station addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
    	List<Station> stations = system.getStations();
    	for(Station station: stations) {
    		Point coordStation = station.getCoordinate();
    		if(coordinate.equals(coordStation)) {
    			// we cannot create a station that already exists
    			return null;
    		}
    	}
        PlusStation station = new PlusStation(coordinate, onService, parkingSlots, money, numberOfLocations);
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    public static Station addPlusStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
    	List<Station> stations = system.getStations();
    	for(Station station: stations) {
    		Point coordStation = station.getCoordinate();
    		if(coordinate.equals(coordStation)) {
    			// we cannot create a station that already exists
    			return null;
    		}
    	}
    	PlusStation station = new PlusStation(coordinate, onService, parkingSlots);
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    public static Station addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
    	List<Station> stations = system.getStations();
    	for(Station station: stations) {
    		Point coordStation = station.getCoordinate();
    		if(coordinate.equals(coordStation)) {
    			// we cannot create a station that already exists
    			return null;
    		}
    	}
    	StandardStation station = new StandardStation(coordinate, onService, parkingSlots, money, numberOfLocations);
       
        stations.add(station);
        system.setStations(stations);

        return station;
    }

    public static Station addStandardStation(MyVelibSystem system, Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
    	List<Station> stations = system.getStations();
    	for(Station station: stations) {
    		Point coordStation = station.getCoordinate();
    		if(coordinate.equals(coordStation)) {
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
