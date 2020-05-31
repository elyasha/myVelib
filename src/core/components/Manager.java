package core.components;
import core.system.MyVelibSystem;

import java.awt.*;
import java.util.List;
//import java.awt.List;
import java.util.ArrayList;

public class Manager extends User {
	public Manager(String name, Point coordinate, int creditCardNumber, double money) {
		super(name, coordinate, creditCardNumber, money);
	}

	public int seeCurrentStatus(int userID) {
		// TODO: Create a method

		return 0;
	}

	public void seeStationCurrentStation(MyVelibSystem system, int stationID) {
		// TODO: Design method
	}

	public void displaySystemReport(MyVelibSystem system) {
		// TODO: Design method
	}
}
