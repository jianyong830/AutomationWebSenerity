package UIPages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class AccountPage extends PageObject {

    public void isLogoExist(){
        shouldBeVisible(By.className("logo"));

    }

    public String doSearch(String searchKey, String productName){
        typeInto($("#search_query_top"), searchKey);
        waitForTextToAppear(productName);
        clickOn($("//li[text()='" + productName + "']"));
        return find(By.tagName("h1")).getText();
    }
}
