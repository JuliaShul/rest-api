package qaguru.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.screenshot;

public class AttachmentsTest {

    private WebSteps steps = new WebSteps();
    private static final String REPOSITORY = "allure";
    private static final String FIND_REPOSITORY = "allure-framework/allure2";

    @Test
    public void testAttachmentAnnotation() {
        steps.openMainPage();

        steps.makeScreenshot();
    }

    @Test
    public void testBasicSteps() {
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(FIND_REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(1303);
        makeScreenshot();
    }

    private void makeScreenshot() {
        InputStream stream = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("Screenshot", stream);
    }
}
