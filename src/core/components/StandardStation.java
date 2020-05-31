package core.components;

import java.awt.*;
import java.util.List;

/**
 * The StandardStation class : This class defines what is a standard station on the application
 */
public class StandardStation extends Station {

    /**
     * A StandardStation constructor
     *
     * @param coordinate        coordinate that will be used to place a plus station
     * @param onService         a boolean parameter to know if the station will be on service
     * @param parkingSlots      a list of parking slots that will populate the plus station
     * @param money             the initial money that the station will have
     * @param numberOfDroppings the number of droppings (or locations)
     */
    public StandardStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfDroppings) {
        super(coordinate, onService, parkingSlots, money, numberOfDroppings);
    }

    /**
     * A (simpler) StandardStation constructor
     *
     * @param coordinate   coordinate that will be used to place a plus station
     * @param onService    a boolean parameter to know if the station will be on service
     * @param parkingSlots a list of parking slots that will populate the plus station
     */
    public StandardStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        super(coordinate, onService, parkingSlots);
    }


}
