package Steps;

import UIPages.ContactUsPage;
import net.thucydides.core.annotations.Step;

public class ContactUsSteps {

        private ContactUsPage contactUsPage;

        @Step
        public String fillContactUsFormStep(){
              return contactUsPage.fillContactUsPage();
        }


}
