package subway.domain.station;

import subway.common.Prefix;
import subway.common.SelectOption;
import subway.view.station.StationManageView;
import subway.view.MainInputView;
import subway.domain.station.StationService;

import java.util.List;
import java.util.Arrays;

public class StationController {
    private static final char ADD_STATION = '1';
    private static final char DELETE_STATION = '2';
    private static final char PRINT_STATION = '3';
    private static final char GO_BACK = 'B';

    public static void stationManagement(MainInputView inputView) {
        List<Character> optionList = Arrays.asList(ADD_STATION, DELETE_STATION, PRINT_STATION, GO_BACK);

        while (true) {
            StationManageView.showStationManagementMenu();
            char option = SelectOption.choice(optionList, inputView);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, inputView)) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, MainInputView inputView) {
        try {
            if (option == ADD_STATION) {
                return addNewStation(inputView);
            }
            if (option == DELETE_STATION) {
                return deleteStation(inputView);
            }
            if (option == PRINT_STATION) {
                return printRegisteredStation();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean addNewStation(MainInputView inputView) {
        StationManageView.askNewStationName();
        String stationName = inputView.stationName();

        Station station = new Station(stationName);
        StationService.addStation(station);

        StationManageView.addStationComplete();
        return true;
    }

    private static boolean deleteStation(MainInputView inputView) {
        StationManageView.askDeleteStationName();
        String stationName = inputView.stationName();

        //validation check
        StationService.deleteStaion(stationName);
        StationManageView.deleteStationComplete();
        return true;
    }

    private static boolean printRegisteredStation() {
        List<Station> stations = StationService.AllStation();
        StationManageView.printAllStation(stations);
        return true;
    }

}