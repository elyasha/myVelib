package core.components;
import core.system.MyVelibSystem;

import java.awt.*;
//import java.awt.List;


public class Manager extends User {
	public Manager(String name, Point coordinate, int creditCardNumber, double money) {
		super(name, coordinate, creditCardNumber, money);
	}

	public void seeMyStatus() {
		System.out.println(this);
	}

	public void seeCurrentStatus(MyVelibSystem system, int userID) {
		User currentUser = null;

		for (User user: system.getUsers()) {
			if (user.getId() == userID){
				currentUser = user;
				break;
			}
		}

		if (currentUser == null) {
			System.out.println("This user is not in the system!");
		}

		else {
			System.out.println(currentUser);
		}


	}

	public void seeCurrentStationState(MyVelibSystem system, int stationID) {
		// Manager can see all systems
		System.out.println();
		Station currentStation = null;
		// Check to see if the station exists
		for (Station station: system.getStations()
		) {
			if (station.getId() == stationID) {
				currentStation = station;
				break;
			}
		}

		if (currentStation == null) {
			System.out.println("The station does not exist in our system!");
		}
		else {
			System.out.println();
			System.out.println("STATION REPORT");
			System.out.println(currentStation);
			System.out.println();
		}


	}

	public void displaySystemReport(MyVelibSystem system) {
		// Manager can see all systems
		System.out.println();
		System.out.println("SYSTEM REPORT");
		System.out.println(system);
		System.out.println();
	}
}
