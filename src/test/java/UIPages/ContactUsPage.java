package UIPages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageObject {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "id_order")
    WebElement orderRef;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(id = "submitMessage")
    WebElement sendButton;


    By heading  = By.id("id_contact"); //this is for select list
    By file = By.id("fileUpload");

    By success = By.cssSelector(".alert-success");

    public String fillContactUsPage(){
        email.sendKeys("naveen@gmail.com");
        orderRef.sendKeys("12345");
        message.sendKeys("Halo");

        element(heading).selectByVisibleText("Webmaster");
        //upload("C:/Users/acer/Downloads/9d(ii).jpg").to(find(file));

        sendButton.click();
        return element(success).getText();
    }

}
