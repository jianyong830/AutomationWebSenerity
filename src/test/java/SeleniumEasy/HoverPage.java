package SeleniumEasy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;

public class HoverPage extends PageObject {
    public void hoverOverFigure(int i) {
      WebElementFacade figure =  $("(//*[@class='figure'])[{0}]",i);

      withAction().moveToElement(figure).perform();
    }

    public WebElementState captionForFigure(int i) {
        return $("(//*[@class='figcaption'])[{0}]", i);
    }
}
