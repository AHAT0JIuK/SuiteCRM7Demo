package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class MainPage extends BasePage {

    public final String MAIN_PAGE_URL = "https://demo.suiteondemand.com/index.php?module=Home&action=Demo";
    private final By MORE_INFORMATION_BUTTON = By.xpath("//*[contains(text(),'Learn more')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        log.info("Открытие страницы MainPage");
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public MainPage isPageOpened() {
        try {
            log.info("Страница MainPage открыта");
            wait.until(ExpectedConditions.visibilityOfElementLocated(MORE_INFORMATION_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Страница MainPage не открылась");
        }
        return this;
    }

}
