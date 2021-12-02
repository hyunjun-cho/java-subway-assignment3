package subway.domain.station;

import subway.domain.station.StationRepository;
import java.util.List;

public class StationService {
    public static void addStation(Station station) {
        StationRepository.addStation(station);
    }

    public static void deleteStaion(String stationName) {
        StationRepository.deleteStation(stationName);
    }
    
    public static List<Station> AllStation() {
        return StationRepository.stations();
    }

    public static Station findStation(String name) {
        return StationRepository.findByName(name);
    }
}