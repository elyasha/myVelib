package core.components;

import java.awt.*;
import java.util.List;

/**
 * The PlusStation class : This class defines what is a plus station on the application
 */
public class PlusStation extends Station {

    /**
     * A PlusStation constructor
     *
     * @param coordinate        coordinate that will be used to place a plus station
     * @param onService         a boolean parameter to know if the station will be on service
     * @param parkingSlots      a list of parking slots that will populate the plus station
     * @param money             the initial money that the station will have
     * @param numberOfDroppings the number of droppings (or locations)
     */
    public PlusStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfDroppings) {
        super(coordinate, onService, parkingSlots, money, numberOfDroppings);
    }

    /**
     * A (simpler) PlusStation constructor
     *
     * @param coordinate   coordinate that will be used to place a plus station
     * @param onService    a boolean parameter to know if the station will be on service
     * @param parkingSlots a list of parking slots that will populate the plus station
     */
    public PlusStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
        super(coordinate, onService, parkingSlots);
    }
}