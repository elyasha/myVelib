package core.components;

public class StandardStation extends Station {

	public StandardStation(int numberOfParkingSlots, float latitude, float longitude, boolean status) {
		this.setNumberOfParkingSlots(numberOfParkingSlots);
		this.setPosition(latitude, longitude);
		this.setStatus(status);
	}

}
