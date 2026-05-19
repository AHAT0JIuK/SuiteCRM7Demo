package steps;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.CreateAccountsPage;

@Log4j2
public class CreateAccountStep {

    WebDriver driver;
    CreateAccountsPage createAccountsPage;
    AccountPage accountPage;

    public CreateAccountStep(WebDriver driver) {
        this.driver = driver;
        createAccountsPage = new CreateAccountsPage(driver);
        accountPage = new AccountPage(driver);
    }

    public AccountPage createAccount(Account account) {
        log.info("Заполнение данных по новому аккаунту...");
        createAccountsPage.open()
                .isPageOpened()
                .addNewAccount(account)
                .save()
                .isPageOpened();
        return new AccountPage(driver);
    }
}
