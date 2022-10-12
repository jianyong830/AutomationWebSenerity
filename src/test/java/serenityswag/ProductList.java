package serenityswag;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductList {
    public static By productDetailsLinkFor(String firstItemName) {
        return By.linkText(firstItemName);
    }
}
