package pages;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.*;

@Log4j2
public class CreateAccountsPage extends BasePage {

    public final String CREATE_ACCOUNTS_PAGE_URL = "https://demo.suiteondemand.com/" +
            "index.php?module=Accounts&action=EditView&return_module=Accounts&return_action=DetailView";
    private final By SAVE_BUTTON = By.xpath("//form/div[@class='buttons']/input[@id='SAVE']");

    public CreateAccountsPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountsPage open() {
        log.info("Открытие страницы CreateAccountsPage");
        driver.get(CREATE_ACCOUNTS_PAGE_URL);
        return this;
    }

    public CreateAccountsPage isPageOpened() {
        try {
            log.info("Страница CreateAccountsPage открыта");
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Страница CreateAccountsPage не открылась");
        }
        return this;
    }

    public CreateAccountsPage addNewAccount(Account account) {
        log.info("Заполнение данных по новому аккаунту с именем '{}'", account.getName());
        // заполнение блока Overview
        new Input(driver, "Name").write(account.getName());
        new Input(driver, "Office Phone").write(account.getPhone());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Fax").write(account.getFax());
        new Checkbox(driver, "Opted Out").click(account.getNumberEmail());
        new Checkbox(driver, "Invalid").click(account.getNumberEmail());
        new AddressTextarea(driver, "Billing Address", "Street").write(account.getBillingStreet());
        new AddressTextarea(driver, "Shipping Address", "Street").write(account.getShippingStreet());
        new AddressInput(driver, "Billing Address", "City").write(account.getCity());
        new AddressInput(driver, "Shipping Address", "City").write(account.getCity());
        new AddressInput(driver, "Billing Address", "State/Region").write(account.getRegion());
        new AddressInput(driver, "Shipping Address", "State/Region").write(account.getRegion());
        new AddressInput(driver, "Billing Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Shipping Address", "Postal Code").write(account.getPostalCode());
        new AddressInput(driver, "Billing Address", "Country").write(account.getCountry());
        new AddressInput(driver, "Shipping Address", "Country").write(account.getCountry());
        new Textarea(driver, "Description").write(account.getDescription());
        // заполнение блока More Information
        new Dropdawn(driver, "Type").select(account.getType());
        new Dropdawn(driver, "Industry").select(account.getIndustry());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver, "Employees").write(account.getEmployees());
        return this;
    }

    public AccountPage save() {
        log.info("Сохранение нового аккаунта");
        driver.findElement(SAVE_BUTTON).click();
        return new AccountPage(driver);
    }
}
