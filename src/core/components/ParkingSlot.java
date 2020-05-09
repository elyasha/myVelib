package core.components;

public class ParkingSlot {
	private final int id = generateUniqueID();
	private static int numberOfParkingSlots = 0;
	private int state; // 0 = free, 1 = occupied and 2 out-of-order
	
	private int generateUniqueID() {
        return ++numberOfParkingSlots;
    }
	
	public ParkingSlot() {
		this.state = 0;
	}
	
	public void setState(int new_state) {
		this.state = new_state;
	}
	
	public int getState() {
		return this.state;
	}
	
	public int getId() {
		return this.id;
	}

}
