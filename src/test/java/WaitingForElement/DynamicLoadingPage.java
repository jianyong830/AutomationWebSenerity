package WaitingForElement;

import SeleniumEasy.FormButton;
import SeleniumEasy.SeleniumEasyForm;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;

@DefaultUrl("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html")
public class DynamicLoadingPage extends SeleniumEasyForm {

    private static final By USER = By.id("loading");
    public void getNewUser() {
        $(FormButton.withLabel("Get New User")).click();
        withTimeoutOf(Duration.ofSeconds(15))
                .waitFor(invisibilityOfElementWithText(USER,"loading..."));
    }

    public String userDescription() {
        return $(USER).getText();
    }
}
