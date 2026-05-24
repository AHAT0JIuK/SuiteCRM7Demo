package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class Checkbox extends BasePage {

    private final String CHEKBOX_PATTERN = "//label[text()='%s']/following-sibling::div" +
            "//*[contains(@value, 'emailAddress";
    String label;

    public Checkbox(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public void click(String numberEmail) {
        log.info("Выбор '{}'-го чекбокса '{}'", Integer.parseInt(numberEmail) + 1, label);
        driver.findElement(By.xpath(String.format(CHEKBOX_PATTERN + numberEmail + "')]", label))).click();
    }
}
