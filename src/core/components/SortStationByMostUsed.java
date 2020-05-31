package core.components;

import java.util.Comparator;

public class SortStationByMostUsed implements Comparator<Station> {

    @Override
    public int compare(Station o1, Station o2) {
        return o1.getNumberOfLocations() - o2.getNumberOfLocations();
    }
}
