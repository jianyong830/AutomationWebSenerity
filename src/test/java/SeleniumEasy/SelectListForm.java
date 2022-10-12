package SeleniumEasy;

import org.openqa.selenium.By;

public class SelectListForm extends SeleniumEasyForm{

    private static final By DAYS_OF_THE_WEEK = By.id("select-demo");
    public String selectedDay() {
        return $(DAYS_OF_THE_WEEK).getSelectedValue();
    }

    public void selectDay(String day) {
        $(DAYS_OF_THE_WEEK).select().byValue(day);
    }
}
