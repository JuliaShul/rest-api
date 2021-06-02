package io.github.eroshenkoam.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
@Owner("eroshenkoam")
public class AnnotatedLabelsTest {

    @Test
    @Story("Создание Issues")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Тест на проверку создания Issue")
    public void testIssueCreate() {

    }

    @Test
    @Story("Удаление Issues")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Тест на проверку удаления Issue от имени автора")
    public void testIssueDelete() {

    }

    @Test
    @Story("Удаление Issues")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Тест на проверку удаления Issue от имени владельца репозитория")
    public void testIssueDeleteFromRepositoryOwner() {

    }

}
