package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

@Log4j2
public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    public MainPage authorization(String user, String password) {
        log.info("Авторизация...");
        loginPage.open()
                .isPageOpened()
                .login("will", "will")
                .isPageOpened();
        return new MainPage(driver);
    }
}
