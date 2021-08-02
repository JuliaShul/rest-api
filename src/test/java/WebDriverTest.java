import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import qaguru.test.owner.SeleniumConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverTest {

    private SeleniumConfig config = ConfigFactory
            .create(SeleniumConfig.class, System.getProperties());

    @Test
    public void testWebDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Autotest\\chromedriver.exe");

        Configuration.browser = config.isBrowser();
        Configuration.browserVersion = config.isVersion();

        final WebDriver driver = createWebDriver();
        driver.get("https://github.com/");
        Thread.sleep(5000);
    }

    private WebDriver createWebDriver() {


        if (config.isRemote()) {
            return new RemoteWebDriver(
                    config.getRemoteUrl(),
                    DesiredCapabilities.chrome()
            );
        } else {
            return new ChromeDriver();
        }
    }
}
//"https://user1:1234@selenoid.autotests.cloud/wd/hub"