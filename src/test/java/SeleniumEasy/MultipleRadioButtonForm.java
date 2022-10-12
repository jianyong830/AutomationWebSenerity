package SeleniumEasy;

public class MultipleRadioButtonForm extends SeleniumEasyForm {


    public void selectGender(String value) {
        inRadioButtonGroup("gender").selectByValue(value);
    }

    public void selectAgeGroup(String value) {
        inRadioButtonGroup("ageGroup").selectByValue(value);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
       return $(".groupradiobutton").getText();
    }
}
