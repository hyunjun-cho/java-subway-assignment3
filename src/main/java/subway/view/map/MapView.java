package subway.view.map;

import subway.common.Prefix;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.line.EachLineStations;

import java.util.List;

public class MapView {
    private static final String DIVIDER = Prefix.INFO.getPrefix() + "---";
    
    public static void showLineInformation(String lineName, EachLineStations stations) {
        System.out.println(Prefix.INFO.getPrefix() + lineName);
        System.out.println(DIVIDER);
        for (Station station : stations.getStations()) {
            System.out.println(Prefix.INFO.getPrefix() + station.getName());
        }
        System.out.println();
    }
    
}