package WaitingForElement;

import SeleniumEasy.SeleniumEasyForm;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.time.Duration;

@DefaultUrl("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html")
public class AlertMessagePage extends SeleniumEasyForm {

    public void openSuccessMessage() {
        $("#autoclosable-btn-success").click();
    }

    public String alertSuccessText() {
        return $(".alert-autocloseable-success").getText();
    }

    public void waitForMessageDisappear() {
        By t = By.cssSelector(".alert-autocloseable-success");
        withTimeoutOf(Duration.ofSeconds(10)).waitForElementsToDisappear(t);

    }

    public WebElementState alertSuccessMessage() {
        return $(".alert-autocloseable-success");
    }
}
