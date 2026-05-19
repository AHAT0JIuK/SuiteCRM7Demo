package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginStep loginStep;
    protected CreateAccountStep createAccountStep;
    protected CheckNewAccountStep checkNewAccountStep;
    protected CreateContactStep createContactStep;
    protected CheckNewContactStep checkNewContactStep;

    @BeforeMethod(alwaysRun = true, description = "Настройка браузера")
    public void setUp() {
        // объявляю настройки для тестового браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--headless");
        // объявляю тестовый браузер
        driver = new ChromeDriver(options);
        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        loginStep = new LoginStep(driver);
        createAccountStep = new CreateAccountStep(driver);
        checkNewAccountStep = new CheckNewAccountStep(driver);
        createContactStep = new CreateContactStep(driver);
        checkNewContactStep = new CheckNewContactStep(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDawn() {
        driver.quit();
    }
}
