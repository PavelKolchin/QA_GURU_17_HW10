package guru_qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllurePrakticTest {

    @Test
    public void testIssueSearch() {
    open("https://github.com/");
    $(".header-search-input").click();
    $(".header-search-input").sendKeys("eroshenkoam/allure-example");
    $(".header-search-input").submit();

    $(linkText("eroshenkoam/allure-example")).click();
    $("#issues-tab").click();
    $(withText("#80")).should(Condition.exist);
    }
}