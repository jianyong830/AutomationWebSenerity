package SeleniumEasy;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenInteractWithInputForm {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    SingleInputFieldForm singleInputFieldForm;
    @Test
    public void basicForms() {

        singleInputFieldForm.open();

        singleInputFieldForm.enterMessage("Hi");

        singleInputFieldForm.showMessage();

        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi");
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    TwoInputFieldForm twoInputFieldForm;
    @Test
    public void basicFormsWithMultipleFields() {

        twoInputFieldForm.open();

        twoInputFieldForm.enterA("2");
        twoInputFieldForm.enterB("3");

        twoInputFieldForm.getTotal();

        assertThat(twoInputFieldForm.displayedMessage()).isEqualTo("Hi");
    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */

    CheckboxForm checkboxForm;
    @Test
    public void singleCheckbox() {

        checkboxForm.open();
        checkboxForm.setAgeSelected();
        assertThat(checkboxForm.agetText()).isEqualTo("Success - Check box is checked");

    }

    private static final List<String> ALL_THE_OPTIONS = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
    @Test
    public void multipleCheckboxes() {

        checkboxForm.open();

        assertThat(ALL_THE_OPTIONS).allMatch(

                option -> !checkboxForm.optionIsCheckedFor(option)
        );

       checkboxForm.checkAll();

        assertThat(ALL_THE_OPTIONS).allMatch(

                option -> checkboxForm.optionIsCheckedFor(option)
        );

    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */

    RadioButtonForm radioButton;
    @Test
    public void radioButtons() {

        radioButton.open();

        radioButton.selectOption("Male");

        radioButton.getCheckedValue();

        assertThat(radioButton.getResult()).isEqualTo("Radio button 'Male' is checked");

    }

    MultipleRadioButtonForm multipleRadioButtonForm;

    @Test
    public void multipleRadioButtons() {

        multipleRadioButtonForm.selectGender("Female");
        multipleRadioButtonForm.selectAgeGroup("15 - 50");
        multipleRadioButtonForm.getValues();

        assertThat(multipleRadioButtonForm.getResult()).contains("Sex : Female").contains("Age group:15 - 50");
    }

    SelectListForm selectListForm;
    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {

        selectListForm.open();

        assertThat(selectListForm.selectedDay()).isEmpty();

        selectListForm.selectDay("Wednesday");

        assertThat(selectListForm.selectedDay()).isEqualTo("Wednesday");


    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */

    MultiSelectListForm multiSelectListForm;
    @Test
    public void multiSelectList() {

        multiSelectListForm.open();

        assertThat(multiSelectListForm.selectedStatus()).isEmpty();

        multiSelectListForm.selectStatus("Florida","Ohio","Texas");

        assertThat(multiSelectListForm.selectedStatus()).containsExactly("Florida","Ohio","Texas");

    }

    HoverPage hoverPage;
    @Test
    public void hover(){

        hoverPage.open();

        hoverPage.hoverOverFigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();
        hoverPage.captionForFigure(1).shouldContainText("user1");
    }
}
