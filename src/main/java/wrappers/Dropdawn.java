package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class Dropdawn extends BasePage {

    private final String SELECT_PATTERN = "//*[contains(text(), '%s')]/following-sibling::div//";
    String label;

    public Dropdawn(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public void select(String option) {
        log.info("Выбор '{}' в '{}'", option, label);
        driver.findElement
                (By.xpath(String.format(SELECT_PATTERN + "select", label))).click();
        driver.findElement
                (By.xpath(String.format(SELECT_PATTERN + "option[contains(text(), '%s')]", label, option))).click();

    }
}
