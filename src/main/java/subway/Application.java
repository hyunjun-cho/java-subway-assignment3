package subway;

import subway.view.MainInputView;
import subway.view.MainOutputView;
import subway.main.SubwayController;
import subway.domain.line.Lineinitialize;
import subway.domain.station.Stationinitialize;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        MainInputView inputView = new MainInputView(scanner);
        Stationinitialize.initStations();
        Lineinitialize.setInitLines();
        
        SubwayController.run(inputView);
    }
}
