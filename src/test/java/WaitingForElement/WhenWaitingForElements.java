package WaitingForElement;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    ModelDialogPage modelDialogPage;

    @Test
    public void waitingForAModalDialog() {
        modelDialogPage.open();

        modelDialogPage.saveChangesButton().shouldNotBeVisible();

        modelDialogPage.openModal();

        modelDialogPage.saveChangesButton().shouldBeVisible();

        modelDialogPage.saveChangesButton();

        modelDialogPage.saveChangesButton().shouldNotBeVisible();

    }

    AlertMessagePage alertMessagePage;
    @Test
    public void waitingForAMessageToClose() {
        alertMessagePage.open();

        alertMessagePage.openSuccessMessage();

        assertThat(alertMessagePage.alertSuccessText()).contains("I'm an autocloseable success message. I will hide in 5 seconds.");

        alertMessagePage.waitForMessageDisappear();

        alertMessagePage.alertSuccessMessage().shouldNotBeVisible();
    }

    DynamicLoadingPage dynamicLoadingPage;
    @Test
    public void waitingForElementsToAppear() {

        dynamicLoadingPage.open();

        dynamicLoadingPage.getNewUser();

        assertThat(dynamicLoadingPage.userDescription())
                .contains("First Name")
                .contains("Last Name");

    }

    @Test
    public void donwloadForm() throws InterruptedException {

        File downloadFile = Paths.get("/User/a.png").toFile();

        Thread.sleep(10000);

        assertThat(downloadFile).exists();

        Awaitility.await().atMost(15, TimeUnit.SECONDS).until(
                downloadFile::exists
        );


    }
}