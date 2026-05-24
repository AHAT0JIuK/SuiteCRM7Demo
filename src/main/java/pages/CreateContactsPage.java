package pages;

import dto.Contact;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.*;

@Log4j2
public class CreateContactsPage extends BasePage {

    public final String CREATE_CONTACTS_PAGE_URL = "https://demo.suiteondemand.com/" +
            "index.php?module=Contacts&action=EditView&return_module=Contacts&return_action=DetailView";
    private final By SAVE_BUTTON = By.xpath("//form/div[@class='buttons']/input[@id='SAVE']");

    public CreateContactsPage(WebDriver driver) {
        super(driver);
    }

    public CreateContactsPage open() {
        log.info("Открытие страницы CreateContactPage");
        driver.get(CREATE_CONTACTS_PAGE_URL);
        return this;
    }

    public CreateContactsPage isPageOpened() {
        try {
            log.info("Страница CreateContactsPage открыта");
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Страница CreateContactsPage не открылась");
        }
        return this;
    }

    public CreateContactsPage addNewContact(Contact contact) {
        log.info("Заполнение данных по новому контакту с фамилией '{}'", contact.getLastName());
        // заполнение блока Overview
        new Dropdawn(driver, "First Name").select(contact.getTitle());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Office Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getPhone());
        new Input(driver, "Job Title").write(contact.getJob());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new Checkbox(driver, "Opted Out").click(contact.getNumberEmail());
        new Checkbox(driver, "Invalid").click(contact.getNumberEmail());
        new AddressTextarea(driver, "Primary Address", "Address").write(contact.getAddress());
        new AddressTextarea(driver, "Other Address", "Address").write(contact.getAddress());
        new AddressInput(driver, "Primary Address", "City").write(contact.getCity());
        new AddressInput(driver, "Other Address", "City").write(contact.getCity());
        new AddressInput(driver, "Primary Address", "State/Region").write(contact.getRegion());
        new AddressInput(driver, "Other Address", "State/Region").write(contact.getRegion());
        new AddressInput(driver, "Primary Address", "Postal Code").write(contact.getPostalCode());
        new AddressInput(driver, "Other Address", "Postal Code").write(contact.getPostalCode());
        new AddressInput(driver, "Primary Address", "Country").write(contact.getCountry());
        new AddressInput(driver, "Other Address", "Country").write(contact.getCountry());
        new Textarea(driver, "Description").write(contact.getDescription());
        // заполнение блока More Information
        new Dropdawn(driver, "Lead Source").select(contact.getLeadSource());
        return this;
    }

    public ContactPage save() {
        log.info("Сохранение нового контакта");
        driver.findElement(SAVE_BUTTON).click();
        return new ContactPage(driver);
    }
}
