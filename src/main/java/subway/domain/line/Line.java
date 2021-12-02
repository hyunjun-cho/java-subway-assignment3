package subway.domain.line;

import subway.domain.station.Station;

public class Line {
    private String name;
    private EachLineStations stations;

    public Line(String name) {
        this.name = name;
        this.stations = new EachLineStations();
    }

    public Line(String name, EachLineStations stations) {
        this.name = name;
        this.stations = stations;
    }
    public String getName() {
        return name;
    }

    public EachLineStations getStations() {
        return stations;
    }

    public void addStation(Station station) {
        stations.addStation(station);
    }

    public boolean isRegistered(String name) {
        return stations.isRegistered(name);
    }
}
