package core.components;

public class PlusStation extends Station {

	public PlusStation(int numberOfParkingSlots, float latitude, float longitude, boolean status) {
	    this.setNumberOfParkingSlots(numberOfParkingSlots);
	    this.setPosition(latitude, longitude);
	    this.setStatus(status);
	}

}