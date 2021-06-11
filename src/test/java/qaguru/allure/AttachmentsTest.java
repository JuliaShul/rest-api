package qaguru.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.screenshot;

public class AttachmentsTest {

    private WebSteps steps = new WebSteps();

    @BeforeEach
    void openGitHub() {
        steps.openMainPage();
    }

    @Test
    void testAttachmentAnnotation() {
        steps.makeScreenshot();
    }

    @Test
    void testBasicSteps() {
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
