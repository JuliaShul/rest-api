package io.github.eroshenkoam.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DynamicLabelsTest {

    @Test
    @DisplayName("Тест на проверку создания Issue (динамические)")
    public void testIssueCreate() {
        Allure.feature("Issues");
        Allure.label("owner", "eroshenkoam");
        Allure.story("Создание Issues");
        Allure.label("severity", SeverityLevel.BLOCKER.toString());
        Allure.link("Github", "https://github.com");
    }

}
