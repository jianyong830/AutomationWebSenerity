package Steps;

import UIPages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginPageSteps {

    private LoginPage loginPage;

    @Step
     public void isOnLoginPage(){
        loginPage.open();
     }

     @Step
    public void loginAsUser(){
        loginPage.doLogin();
     }

     @Step
    public void userShouldBeLogin(){
         Assert.assertTrue(loginPage.accountPageVisible().equals("MY ACCOUNT"));
     }

     @Step
    public void navigateToContactUsPage(){
        loginPage.goToContactUsPage();
     }
}
