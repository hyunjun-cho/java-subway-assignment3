package subway.domain.line;

import subway.common.SelectOption;
import subway.domain.station.Station;
import subway.domain.station.StationService;
import subway.view.MainInputView;
import subway.view.line.LineManageView;

import java.util.Arrays;
import java.util.List;

public class LineController {
    private static final char ADD_LINE = '1';
    private static final char DELETE_LINE = '2';
    private static final char PRINT_LINE = '3';
    private static final char GO_BACK = 'B';

    public static void lineManage(MainInputView inputView) {
        List<Character> optionList = Arrays.asList(ADD_LINE, DELETE_LINE, PRINT_LINE, GO_BACK);

        while(true) {
            LineManageView.showLineManagementMenu();
            char option = SelectOption.choice(optionList, inputView);

            if(option == GO_BACK) {
                break;
            }
            if(SelectOption(option, inputView)){
                break;
            }
        }
    }

    private static boolean SelectOption(char option, MainInputView inputView) {
        try {
            if(option == ADD_LINE) {
                return addNewLine(inputView);
            }
            if(option == DELETE_LINE) {
                return deleteLine(inputView);
            }
            if(option == PRINT_LINE) {
                return printRegisteredLine();
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    private static Line getNewLine(MainInputView inputView) {
        LineManageView.askNewLineName();
        String lineName = inputView.lineName();
        return new Line(lineName);
    }

    private static boolean addNewLine(MainInputView inputView) {
        Line line = getNewLine(inputView);
        Station startStation = getStartStation(inputView);
        Station endStation = getEndStation(startStation, inputView);

        LineService.addLineWithStartEndStation(line, startStation, endStation);

        LineManageView.addLineComplete();
        return true;
    }

    private static Station getStartStation(MainInputView inputView) {
        LineManageView.askStartStationName();
        String startStationName = inputView.stationName();
        return StationService.findStation(startStationName);
    }

    private static Station getEndStation(Station startStation, MainInputView inputView) {
        LineManageView.askEndStationName();
        String endStationName = inputView.stationName();
        return StationService.findStation(endStationName);
    }

    private static boolean deleteLine(MainInputView inputView) {
        LineManageView.askDeleteLineName();
        String lineName = inputView.lineName();

        LineService.deleteLine(lineName);
        
        LineManageView.deleteLineComplete();
        return true;
    }

    private static boolean printRegisteredLine() {
        List<Line> lines = LineService.allLine();
        LineManageView.showAllLine(lines);
        return true;
    }
} 