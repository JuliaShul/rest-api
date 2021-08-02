package qaguru.test.owner;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    private WebConfig config = new WebConfig() {
        @Override
        public String getBaseUrl( ) {
            return null;
        }

        @Override
        public String getUsername( ) {
            return null;
        }

        @Override
        public String getPassword( ) {
            return null;
        }
    };

    @Test
    void testIssueSearch() {
        Configuration.baseUrl = config.getBaseUrl();

        open("/login");
        $("#login_field").sendKeys(config.getUsername());
        $("#password").sendKeys(config.getPassword());
    }

}
