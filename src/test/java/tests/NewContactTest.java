package tests;

import dto.Contact;
import helpers.ContactFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class NewContactTest extends BaseTest {

    Contact contact = ContactFactory.getContact("Miss", "0", "Conference");

    @Test
    public void checkAddNewContact() throws InterruptedException {
        loginStep.authorization("will", "will");
        createContactStep.createContact(contact);
        checkNewContactStep.matchingContact(contact);
    }
}
