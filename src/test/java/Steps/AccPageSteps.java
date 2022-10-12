package Steps;

import UIPages.AccountPage;
import net.thucydides.core.annotations.Step;

public class AccPageSteps {

    private AccountPage accountPage;

    @Step
    public void validateAppLogo(){
        accountPage.isLogoExist();
    }

    @Step
    public String searchProducts(String searchKey, String productName){
        return accountPage.doSearch(searchKey, productName);
    }
}
