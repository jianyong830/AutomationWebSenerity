package CreateStudentsDataDrivenTest;

import AppTests.BaseTest;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import Steps.*;
import org.junit.runner.RunWith;

@UseTestDataFrom("your csv file for data driven test")
@RunWith(SerenityParameterizedRunner.class) //means this is data driven test
public class CreateStudent extends BaseTest {

    //create getter setter
    //then run the test by submit to the createMultipleContact Us Form
    @Steps
    ContactUsSteps contactUsSteps;

    @Title("Data Driven Test")

    @Test
    public void createMultipleContactUsForm(){
        contactUsSteps.fillContactUsFormStep();
    }

    @Test
    public void testGherkin(){
        Actor tester = new Actor("tester");

    }


}
