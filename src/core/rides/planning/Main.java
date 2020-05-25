package core.rides.planning;
import java.util.ArrayList;
import java.util.List;
import core.components.*;

public class Main {
	
	
	public List<Station> getBestStation(List<Float> coordsStart,List<Float> coordsEnd, Bicycle bike) {
		Manager manager = new Manager();
		List<Float> coords = new ArrayList<Float>(2);
		double distance, distanceSq;
		double bestDistanceStart = Double.POSITIVE_INFINITY; 
		double bestDistanceEnd = Double.POSITIVE_INFINITY;
		Station bestStationStart = null;
		Station bestStationEnd = null;
		List<Station> allStations;
		List<Station> bestStations = new ArrayList<Station>(2);
		
		allStations = manager.getAllStations();
		
		
		for (Station station : allStations) {
			
			coords = station.getPosition();
			
			// Compute the nearest station for the starting point
			distanceSq = Math.pow(coords.get(0)- coordsStart.get(0), 2)+Math.pow(coords.get(1)- coordsStart.get(1), 2);
			distance = Math.sqrt(distanceSq);
			if (distance < bestDistanceStart && station.GetExistTypeBike(bike)) {
				bestDistanceStart =  distance;
				bestStationStart = station;
			}
			
			
			// Compute the nearest station for the ending point
			distanceSq = Math.pow(coords.get(0)- coordsEnd.get(0), 2)+Math.pow(coords.get(1)- coordsEnd.get(1), 2);
			distance = Math.sqrt(distanceSq);
			if (distance < bestDistanceEnd && station.GetOneSlotFree()) {
				bestDistanceEnd =  distance;
				bestStationEnd = station;
			}
			
		}
		bestStations.add(bestStationStart);
		bestStations.add(bestStationEnd);
		
		return bestStations;
	}
}
