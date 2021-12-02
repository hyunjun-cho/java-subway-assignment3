package subway.domain.station;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stationinitialize {
    private static final String initStation = "교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역";
    private static final List<String> initStations = Arrays.asList(stringToArray(initStation));

    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public static void initStations() {
        for(String name : initStations) {
            Station station = new Station(name);
            StationService.addStation(station);
        }
    }
    public static String[] stringToArray(String string) {
        return Stream.of(string.split(COMMA)).map(s -> s.replaceAll(BLANK, EMPTY)).toArray(String[]::new);
    }
}