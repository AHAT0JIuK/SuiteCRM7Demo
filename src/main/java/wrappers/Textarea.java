package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class Textarea extends BasePage {

    private final String TEXTAREA_PATTERN = "//*[contains(text(),'%s')]/following-sibling::div//textarea";
    String label;

    public Textarea(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public void write(String text) {
        log.info("Запись '{}' в '{}'", text, label);
        driver.findElement(By.xpath(String.format(TEXTAREA_PATTERN, label))).sendKeys(text);
    }
}
