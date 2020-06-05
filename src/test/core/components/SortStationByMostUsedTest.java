package core.components;

import core.components.factories.ParkingSlotsFactory;
import core.statistics.balance.station.StationApp;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
/**
 * Testing SortStationByMostUsed Class
 */
public class SortStationByMostUsedTest {

    /**
     * Testing compare method
     */
    @Test
    public void compare1() {
        // super(coordinate, onService, parkingSlots, money, numberOfDroppings);
        List<ParkingSlot> listParking = ParkingSlotsFactory.createFreeParkingSlots(10);
        Station station1 = new PlusStation(new Point(0, 0), true, listParking, 1000, 50);
        Station station2 = new StandardStation(new Point(0, 0), true, listParking, 1000, 10);

        List<Station> list = new ArrayList<>();

        // adding the stations to the list
        list.add(station1);
        list.add(station2);

        List<Station> mostUsedStations = StationApp.sortStationByMostUsed(list); // Should return station1, station2 in this order

        assertEquals(list, mostUsedStations);
    }

}