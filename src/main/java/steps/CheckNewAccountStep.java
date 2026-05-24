package steps;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

import static org.testng.AssertJUnit.assertEquals;

@Log4j2
public class CheckNewAccountStep {

    WebDriver driver;
    AccountPage accountPage;

    public CheckNewAccountStep(WebDriver driver) {
        this.driver = driver;
        accountPage = new AccountPage(driver);
    }

    public AccountPage matchingAccount(Account account) {
        try {
            log.info("Сравнение заголовка страницы нового аккаунта '{}' с заполненным ранее именем '{}' " +
                    "в нижнем регистре", accountPage.getTitle(), account.getName());
            assertEquals(accountPage.getTitle().toLowerCase(), account.getName().toLowerCase());
        } catch (AssertionError e) {
            log.error(e.getMessage());
            Assert.fail("Сравнение прошло неуспешно.");
        }
        return new AccountPage(driver);
    }
}
