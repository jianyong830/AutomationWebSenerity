package SeleniumEasy;

import org.openqa.selenium.By;

public class TwoInputFieldForm extends SeleniumEasyForm {
    public void enterA(String value) {
        $("#sum1").sendKeys(value);
    }

    public void enterB(String value) {
        $("#sum2").sendKeys(value);
    }

    public void getTotal() {
        $(FormButton.withLabel("Get Total")).click();
    }

    public String displayedTotal(){
        return $("#displayvalue").getText();
    }

    public String displayedMessage() {
        return $("#display").getText();
    }
}
