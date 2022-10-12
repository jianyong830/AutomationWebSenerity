package serenityswag;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

@RunWith(SerenityRunner.class)
public class WhenViewingHightlightedProducts extends UIInteractionSteps {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    ViewProductDetailsAction viewProductDetailsAction;


    InventoryPage inventoryPage;

    ProductListPageObject productListPageObject;

    ProductDetailPageObject productDetail;
    
    @Test
    public void checkProductDisplayed(){
        login.as(User.STANDARD_USER);

        List<String> products = productListPageObject.titles();

        Assert.assertTrue(products.size() == 6 && products.contains("Sauce Labs Backpack"));

    }

    @Test
    public void hightlightedProductsShouldDisplayTheCorrespondingImg(){
        login.as(User.STANDARD_USER);
        List<String> products = productListPageObject.titles();


        products.forEach(
                productName -> Assert.assertTrue(productListPageObject.imageTextForProduct(productName).equalsIgnoreCase(productName))
        );
    }


    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(User.STANDARD_USER);

        String firstItemName = productListPageObject.titles().get(0);

        viewProductDetailsAction.forProductWithName(firstItemName);

        Serenity.reportThat("The product name should be correct displayed",
                () -> Assert.assertTrue(productDetail.productName().equals(firstItemName))
                );


        productDetail.productImageWithAltValueOf(firstItemName).shouldBeVisible();

    }
}
