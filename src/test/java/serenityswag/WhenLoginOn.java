package serenityswag;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenLoginOn extends UIInteractionSteps {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;


    @Test
    public void userCanLogOnViaHomePage(){
        login.as(User.STANDARD_USER);


        //should see product
        Serenity.reportThat("The inventory page should be displayed with the correct title", () ->
                Assert.assertTrue(inventoryPage.getHeading().equalsIgnoreCase("Products"))
        );

    }
}
