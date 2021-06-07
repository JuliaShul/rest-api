package qaguru.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.screenshot;

public class AttachmentsTest {

    private WebSteps steps = new WebSteps();

    @Test
    public void testAttachmentAnnotation() {
        steps.openMainPage();
        steps.makeScreenshot();
    }

    @Test
    public void testBasicSteps() {
        steps.searchForRepository("allure");
        steps.goToRepository("allure-framework/allure2");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(1303);
        makeScreenshot();
    }

    private void makeScreenshot() {
        InputStream stream = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("Screenshot", stream);
    }
}
