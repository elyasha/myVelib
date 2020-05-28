package core.components;

import java.awt.*;
import java.util.List;

public class StandardStation extends Station {

	public StandardStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
		super(coordinate, onService, parkingSlots, money, numberOfLocations);
	}

	public StandardStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
		super(coordinate, onService, parkingSlots);
	}


}
