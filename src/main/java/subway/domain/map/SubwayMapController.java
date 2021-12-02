package subway.domain.map;

import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.line.EachLineStations;
import subway.view.map.MapView;

import java.util.List;

public class SubwayMapController {
    public static void showSubwayMap() {
        List<Line> lines = LineService.allLine();

        for(Line line : lines) {
            String lineName = line.getName();
            EachLineStations stations = line.getStations();
            MapView.showLineInformation(lineName, stations);
        }
    }
}