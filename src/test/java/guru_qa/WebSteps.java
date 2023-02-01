package guru_qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу github.com")
    public void openMainPage() {
        open("https://github.com/");
    }

    ;

    @Step("Ищем репозиторний {repo}")
    public void searchRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void selectRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issue")
    public void openTabIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {ISSUE}")
    public void checkIssueNumber(int ISSUE) {
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public void source() {
        attachment("Source", webdriver().driver().source());
    }
}
