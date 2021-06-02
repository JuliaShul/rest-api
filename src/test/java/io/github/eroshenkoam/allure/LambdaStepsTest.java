package io.github.eroshenkoam.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testIssueSearch() {
        step("Открываем главную старницу", (s) -> {
            s.parameter("Урл", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Открываем таб Issues в репозитории", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем что Issue c номером " + ISSUE_NUMBER + " существует", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            $(withText("#68")).should(Condition.exist);
        });
    }

}
