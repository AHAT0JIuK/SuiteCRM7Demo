package steps;

import dto.Contact;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactPage;

import static org.testng.AssertJUnit.assertEquals;

@Log4j2
public class CheckNewContactStep {

    WebDriver driver;
    ContactPage contactPage;

    public CheckNewContactStep(WebDriver driver) {
        this.driver = driver;
        contactPage = new ContactPage(driver);
    }

    public ContactPage matchingContact(Contact contact) {
        try {
            log.info("Сравнение заголовка страницы нового контакта '{}' с заполненными ранее обращением '{}'," +
                            " именем '{}' и фамилией '{}' в верхнем регистре", contactPage.getTitle(),
                    contact.getTitle(), contact.getFirstName(), contact.getLastName());
            assertEquals(contactPage.getTitle(),
                    (contact.getTitle() + " " + contact.getFirstName() + " " + contact.getLastName()).toUpperCase());
        } catch (AssertionError e) {
            log.error(e.getMessage());
            Assert.fail("Сравнение прошло неуспешно.");
        }
        return new ContactPage(driver);
    }
}
