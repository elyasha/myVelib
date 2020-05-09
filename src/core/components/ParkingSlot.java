package core.components;

public class ParkingSlot {
	private final int id;
	private static int numberOfSlots = 0;
	private int state; // 0 = free, 1 = occupied and 2 out-of-order
	
	private int generateUniqueID() {
        return ++numberOfSlots;
    }
	
	public ParkingSlot() {
		this.state = 0;
		this.id = generateUniqueID();
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
