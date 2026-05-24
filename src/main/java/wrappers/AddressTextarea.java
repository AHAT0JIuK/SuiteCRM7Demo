package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class AddressTextarea extends BasePage {

    private final String ADDRESS_TEXTAREA_PATTERN = "//*[contains(text(), '%s')]" +
            "/ancestor::div[contains(@class, 'edit-view-row-item')]//*[contains(text(), '%s')]" +
            "//ancestor::tr//textarea";
    String addressLabel;
    String label;

    public AddressTextarea(WebDriver driver, String addressLabel, String label) {
        super(driver);
        this.addressLabel = addressLabel;
        this.label = label;
    }

    public void write(String text) {
        log.info("Запись '{}' в '{}' в блоке '{}'", text, label, addressLabel);
        driver.findElement(By.xpath(String.format(ADDRESS_TEXTAREA_PATTERN, addressLabel, label))).sendKeys(text);
    }
}
