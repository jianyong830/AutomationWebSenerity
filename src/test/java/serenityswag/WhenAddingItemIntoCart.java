package serenityswag;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class WhenAddingItemIntoCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;


    @Steps
    AddToCartActions addToCart;

    ShoppingCartBadge shoppingCartBadge;

    ProductListPageObject productList;

    @Before
    public void Login()
    {
        login.as(User.STANDARD_USER);
    }

    @Test
    public void theCorrectItemCountShowBeShown(){

        Assert.assertTrue(shoppingCartBadge.count().isEmpty());


        addToCart.item("Sauce Labs Backpack");

        Assert.assertTrue(shoppingCartBadge.count().equals("1"));
    }

    @Test
    public void allTheItemShouldAppearInCart(){

        List<String> productTitles = firstThreeProductTitlesDisplayed();

        String cartBadgeCount = Integer.toString(productTitles.size());
        addToCart.items(productTitles);

        //navigate to cart

        addToCart.openCart();

        Assert.assertTrue(addToCart.displayedItems().containsAll(productTitles));
    }

    CartPageObject cartPage;

    @Test
    public void pricesForEachItemShouldBeShownInClass(){

        //add item to shopping cart
        addToCart.items(firstThreeProductTitlesDisplayed());
        //open cart page
        cartPage.open();
        //check each item in cart has price
        List<CartItem> items = cartPage.items();

        assertThat(items).hasSize(3)
                .allMatch(item -> item.price > 0.0);
    }


    private List<String> firstThreeProductTitlesDisplayed() {
        return productList.titles().subList(0,3);
    }
}
