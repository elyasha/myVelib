package core.components;

import java.util.Objects;

public class ParkingSlot {
	private final int id = generateUniqueID();
	private static int numberOfSlots = 0;
	private int state; // 0 = free, 1 = occupied and 2 out-of-order
	private Bicycle bike;

	public ParkingSlot(int state, Bicycle bicycle) {
		this.state = state;
		this.bike = bicycle;
	}

	private int generateUniqueID() {
        return ++numberOfSlots;
    }
	
	public ParkingSlot() {
		this.state = 0;
	}
	
	public void setState(int state) {
		this.state = state;
	}

	public void setState(int state, Bicycle bicycle) {
		this.state = state;
		this.bike = bicycle;
	}

	public Bicycle getBike() {
		return bike;
	}

	public void setBike(Bicycle bike) {
		this.bike = bike;
	}

	public int getState() {
		return this.state;
	}
	
	public int getId() {
		return this.id;
	}

	public static int getNumberOfSlots() {
		return numberOfSlots;
	}

	@Override
	public String toString() {
		return "ParkingSlot{" +
				"id=" + id +
				", state=" + state +
				'}';
	}
	
	public void setTypeBike(Bicycle bike) {
		this.bike = bike;
	}
	
	public Bicycle getTypeBike() {
		return this.bike;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParkingSlot that = (ParkingSlot) o;
		return id == that.id &&
				state == that.state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, state);
	}
}
