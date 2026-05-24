package steps;

import dto.Contact;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;
import pages.CreateContactsPage;

@Log4j2
public class CreateContactStep {

    WebDriver driver;
    CreateContactsPage createContactsPage;
    ContactPage contactPage;

    public CreateContactStep(WebDriver driver) {
        this.driver = driver;
        createContactsPage = new CreateContactsPage(driver);
        contactPage = new ContactPage(driver);
    }

    public ContactPage createContact(Contact contact) {
        log.info("Заполнение данных по новому контакту...");
        createContactsPage.open()
                .isPageOpened()
                .addNewContact(contact)
                .save()
                .isPageOpened();
        return new ContactPage(driver);
    }
}
