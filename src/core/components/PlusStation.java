package core.components;

import java.awt.*;
import java.util.List;

public class PlusStation extends Station {
	public PlusStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots, double money, int numberOfLocations) {
		super(coordinate, onService, parkingSlots, money, numberOfLocations);
	}

	public PlusStation(Point coordinate, boolean onService, List<ParkingSlot> parkingSlots) {
		super(coordinate, onService, parkingSlots);
	}
}