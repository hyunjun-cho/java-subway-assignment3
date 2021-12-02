package subway.common;

import subway.main.CheckOption;
import subway.view.MainInputView;
import subway.view.MainOutputView;

import java.util.List;

public class SelectOption {
    public static char choice(List<Character> optionList, MainInputView mainInputView) {
        char option;
        while(true) {
            try {
                MainOutputView.questionChoice();
                option = mainInputView.selectOption();
                CheckOption.validation(option, optionList);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }
}