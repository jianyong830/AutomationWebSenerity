package SeleniumEasy;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
public class CheckboxForm extends SeleniumEasyForm {


    public void setAgeSelected() {
        $("#isAgeSelected").click();

    }

    public String agetText() {
        return $("#txtAge").getText();
    }

    public boolean optionIsCheckedFor(String option) {
        return $("//label[contains(.,'{0}')]/input", option).isSelected();
    }

    public void checkAll() {
        $("//input[@value='Check All']").click();
    }
}