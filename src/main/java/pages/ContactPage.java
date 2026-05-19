package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ContactPage extends BasePage {

    private final By SUBPANEL_SECURITY_GROUPS = By.id("subpanel_title_securitygroups");
    private final By TITLE = By.xpath("//div[@class='moduleTitle']/h2");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage isPageOpened() {
        try {
            log.info("Страница ContactPage открыта");
            wait.until(ExpectedConditions.visibilityOfElementLocated(SUBPANEL_SECURITY_GROUPS));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Страница ContactPage не открылась");
        }
        return this;
    }

    public String getTitle() {
        log.info("Заголовок страницы взят в обработку");
        return driver.findElement(TITLE).getText();
    }
}
