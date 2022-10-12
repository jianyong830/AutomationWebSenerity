package WaitingForElement;

import SeleniumEasy.SeleniumEasyForm;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demo.seleniumeasy.com/bootstrap-modal-demo.html")
public class ModelDialogPage extends SeleniumEasyForm {

    private static By LAUNCH_MODAL_BUTTON = By.linkText("Launch modal");
    private static By SAVE_CHANGES_BUTTON = By.linkText("Save modal");

    public void openModal(){
        find(LAUNCH_MODAL_BUTTON).click();
    }

    public WebElementState saveChangesButton(){
        return find(SAVE_CHANGES_BUTTON);
    }

    public void SaveChanges(){
        find(SAVE_CHANGES_BUTTON).click();
    }

}
