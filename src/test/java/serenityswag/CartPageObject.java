package serenityswag;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    @FindBy(id = "checkout")
    //@FindBy(css = "[data-test=checkout]")
    WebElementFacade checkoutButton;

    @FindBy(css = ".title")
    WebElementFacade title;

    private static By CHECKOUT_BUTTON = By.id("checkout");
    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItemElements;

    By CART_ITEMS = By.cssSelector(".cart_item");

    public void checkout(){
        $(CHECKOUT_BUTTON).click();
    }

    public String getTitleText(){
        return title.getText();
    }

    public List<CartItem> items() {

        //old way
//        List<CartItem> cartItems = new ArrayList<>();
//        for(WebElementFacade cartItemFacade: cartItemElements)
//        {
//            String name  = cartItemFacade.findBy(".inventory_item_name").getText();
//            String description = cartItemFacade.findBy(".inventory_item_desc").getText();
//            Double price = priceFrom(cartItemFacade.findBy(".inventory_item_price").getText());
//            cartItems.add(new CartItem(name,description,price));
//        }
//        return cartItems;

        //New way create and return new cart items
       return findAll(CART_ITEMS).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFrom(item.findBy(".inventory_item_price").getText())
                )
        );

    }

    private Double priceFrom(String text) {
        return Double.parseDouble(text.replace("$",""));
    }
}
