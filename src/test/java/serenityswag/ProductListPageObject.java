package serenityswag;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public static By addToCartItem(String itemName) {
        return By.xpath("//div[@class='inventory_item'][contains(.,'" + itemName + "')]//button");
    }

    public List<String> titles(){
        return findAll(".inventory_item_name").textContents();
    }

    public void openProductDetails(String firstItemName) {
        find(By.linkText(firstItemName)).click();
    }

    public String imageTextForProduct(String productName) {
        return find(By.xpath(("//div[@class='inventory_item' and contains(.,'" + productName +"')]//img"))).getAttribute("alt");
    }


}
