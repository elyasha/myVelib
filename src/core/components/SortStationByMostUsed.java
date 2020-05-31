package core.components;

import java.util.Comparator;

/**
 * The SortStationByMostUsed class : this class implements an algorithm to sort the stations by the most used strategy
 */
public class SortStationByMostUsed implements Comparator<Station> {

    /**
     * This method is used to compare two stations
     * @param o1 the station o1
     * @param o2 the station o2
     * @return an integer that represents whether or not the o1 station is more used than the o2 station
     */
    @Override
    public int compare(Station o1, Station o2) {
        return o1.getNumberOfDroppings() + o1.getNumberOfRentings() - o2.getNumberOfDroppings() - o2.getNumberOfRentings();
    }
}
