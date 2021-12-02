package subway.main;

import subway.common.SelectOption;
import subway.view.MainInputView;
import subway.view.MainOutputView;
import subway.view.line.LineManageView;
import subway.view.station.StationManageView;
import subway.view.section.SectionManageView;
import subway.domain.station.StationController;
import subway.domain.line.LineController;
import subway.domain.map.SubwayMapController;
import subway.view.map.MapView;
import java.util.Arrays;
import java.util.List;

public class SubwayController {
    private static final char STATION_MANAGEMENT = '1';
    private static final char LINE_MANAGEMENT = '2';
    private static final char SECTION_MANAGEMENT = '3';
    private static final char PRINT_LINE_MAP = '4';
    private static final char EXIT_SERVICE = 'Q';

    public static void run(MainInputView mainInputView) {
        List<Character> optionList = Arrays.asList(STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, PRINT_LINE_MAP, EXIT_SERVICE);

        while(true) {
            MainOutputView.showMainView();
            char option = SelectOption.choice(optionList, mainInputView);
            if(option == EXIT_SERVICE) {
                break;
            }
            navigateSubMenu(option, mainInputView);
        }
    }
    private static void navigateSubMenu(char option, MainInputView mainInputView) {
        if(option == STATION_MANAGEMENT) {
            StationController.stationManagement(mainInputView);
        }
        if(option == LINE_MANAGEMENT) {
            LineController.lineManage(mainInputView);
        }
        if(option == SECTION_MANAGEMENT) {

        }
        if(option == PRINT_LINE_MAP) {
            SubwayMapController.showSubwayMap();
        }
    }
}