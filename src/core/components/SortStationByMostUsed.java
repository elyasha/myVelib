package core.components;

import java.util.Comparator;

public class SortStationByMostUsed implements Comparator<Station> {

    @Override
    public int compare(Station o1, Station o2) {
        return o1.getNumberOfDroppings() + o1.getNumberOfRentings() - o2.getNumberOfDroppings() - o2.getNumberOfRentings();
    }
}
