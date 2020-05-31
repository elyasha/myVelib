package core.components;

import java.util.Objects;

/**
 * The ParkingSlot class: This class defines what is a parking slot and how it will behave in the application
 */
public class ParkingSlot {
	/**
	 * The unique id of a parking slot
	 */
	private final int id = generateUniqueID();

	/**
	 * The number of parking slots
	 */
	private static int numberOfSlots = 0;

	/**
	 * The state on a parking slot
	 *
	 * if state = 0 : the parking slot is free
	 * if state = 1 : the parking slot is occupied
	 * if state = 2 : the parking slot is out-of-order
	 */
	private int state; // 0 = free, 1 = occupied and 2 out-of-order

	/**
	 * This is the bicycle that a parking slot may have
	 *
	 * If the parking slot does not have a bicycle, this parameter will be null
	 */
	private Bicycle bicycle;

	/**
	 * The ParkingSlot constructor
	 * @param state an initial state
	 * @param bicycle an initial bicycle (may be null)
	 */
	public ParkingSlot(int state, Bicycle bicycle) {
		this.state = state;
		this.bicycle = bicycle;
	}

	/**
	 * This methods generates an unique id
	 * @return the unique id
	 */
	private int generateUniqueID() {
        return ++numberOfSlots;
    }

	/**
	 * The ParkingSlot constructor (that take no argument)
	 *
	 * This constructor will set the initial state to zero (free)
	 */
	public ParkingSlot() {
		this.state = 0;
	}

	/**
	 * Setter for state
	 * @param state the state of the parking slot
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Setter for state
	 * @param state the state of the parking slot
	 * @param bicycle a bicycle parameter that the slot will storage
	 */
	public void setState(int state, Bicycle bicycle) {
		this.state = state;
		this.bicycle = bicycle;
	}

	/**
	 * Getter for bicycle
	 * @return bicycle
	 */
	public Bicycle getBicycle() {
		return bicycle;
	}

	/**
	 * Setter for bicycle
	 * @param bicycle bicycle
	 */
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	/**
	 * Getter for state
	 * @return state
	 */
	public int getState() {
		return this.state;
	}

	/**
	 * Getter for id
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Getter for numberOfSlots
	 * @return numberOfSlots
	 */
	public static int getNumberOfSlots() {
		return numberOfSlots;
	}

	/**
	 * toString method for the ParkingSlot class
	 * @return a message that represent the ParkingSlot object
	 */
	@Override
	public String toString() {
		return "ParkingSlot{" +
				"id=" + id +
				", state=" + state +
				'}';
	}

	/**
	 * equals method for the ParkingSlot class
	 * @param o an object
	 * @return true, if the two objects are "equal"; false, otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParkingSlot that = (ParkingSlot) o;
		return id == that.id &&
				state == that.state;
	}

	/**
	 * hashCode method for the ParkingSlot class
	 * @return hash(id, state)
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, state);
	}
}
