package SeleniumEasy;

public class RadioButtonForm extends SeleniumEasyForm{

    public void selectOption(String value) {
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        $("buttoncheck").click();
    }

    public String getResult(){
        return $(".radiobutton").getText();
    }
}
