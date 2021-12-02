package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lineinitialize {
    private static final String lineTwo = "2호선, 교대역, 강남역, 역삼역";
    private static final String lineThree = "3호선, 교대역, 남부터미널역, 양재역, 매봉역";
    private static final String lineNew = "신분당선, 강남역, 양재역, 양재시민의숲역";
    private static final List<String> initLineList = Arrays.asList(lineTwo, lineThree, lineNew);

    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public static void setInitLines() {
        for(String line : initLineList) {
            List<String> stations = Arrays.asList(stringToArray(line));
            String lineName = stations.get(0);
            EachLineStations lineStations = new EachLineStations(getStationList(stations, lineName));
            Line newLine = new Line(lineName, lineStations);
            LineService.addLine(newLine);
        }
    }

    private static List<Station> getStationList(List<String> lines, String lineName) {
        List<Station> stations = new ArrayList<>();

        for(String stationName : lines) {
            if(!stationName.equals(lineName)) {
                Station station = StationService.findStation(stationName);
                stations.add(station);
            }
        }

        return stations;
    }

    public static String[] stringToArray(String string) {
        return Stream.of(string.split(COMMA)).map(s -> s.replaceAll(BLANK, EMPTY)).toArray(String[]::new);
    }
}