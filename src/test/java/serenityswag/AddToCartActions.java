package serenityswag;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;

public class AddToCartActions extends UIInteractionSteps {

    @Step("Add {0} to cart")
    public void item(String itemName){
        $(ProductListPageObject.addToCartItem(itemName)).click();

    }

    @Step("Add multiple item to cart")
    public void items(List<String> productTitles) {
        for(String itemName: productTitles){
            item(itemName);
        }
    }

    @Step("Open the shopping cart")
    public void openCart() {
        $(".shopping_cart_link").click();
    }

    public List<String> displayedItems() {
        return findAll(".inventory_item_name").texts();
    }
}
