package AppTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jsoup.Connection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.*;

@RunWith(SerenityRunner.class)
public class ContactUsTest extends BaseTest {

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    ContactUsSteps contactUsSteps;

    @Before
    public void setup(){
        loginPageSteps.isOnLoginPage();
        loginPageSteps.navigateToContactUsPage();
    }

    @Test
    public void fillContactUsPageTest(){
       String result =  contactUsSteps.fillContactUsFormStep();
        Assert.assertTrue(result.equals("Your message has been successfully sent to our team."));
    }
}
