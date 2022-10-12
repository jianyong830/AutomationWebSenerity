package serenityswag;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0} ")
    public void as(User user){
        //driver.get("https://www.saucedemo.com/");
        openUrl("https://www.saucedemo.com/");

        //Login as a standard user
        //driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        //driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        //driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        //Alternative way
        //find("[data-test='username']").sendKeys("standard_user");

        //Alternative
        $(LoginForm.USER_NAME).sendKeys(user.getUsername());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();

        //By id selector
        //find(By.id("password"));
        //OR
        //find("#user-name");

        //By Name
        //find("[name=password]");
    }
}
