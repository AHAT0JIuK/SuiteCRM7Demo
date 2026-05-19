package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class Input extends BasePage {

    private final String INPUT_PATTERN = "//div[contains(text(), '%s')]/parent::div//input";
    String label;

    public Input(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public void write(String text) {
        log.info("Запись '{}' в '{}'", text, label);
        driver.findElement(By.xpath(String.format(INPUT_PATTERN, label)))
                .sendKeys(text);
    }
}
