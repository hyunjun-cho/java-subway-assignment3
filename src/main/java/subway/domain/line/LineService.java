package subway.domain.line;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;

import java.util.List;

public class LineService {
    public static void addLine(Line line) {
        LineRepository.addLine(line);
    } 
    public static void addLineWithStartEndStation(Line line, Station startStation, Station endStation) {
        line.addStation(startStation);
        line.addStation(endStation);
        LineRepository.addLine(line);
    }

    public static void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }

    public static Line findLine(String lineName) {
        return LineRepository.findByName(lineName);
    }

    public static List<Line> allLine()  {
        return LineRepository.lines();
    }
    
}