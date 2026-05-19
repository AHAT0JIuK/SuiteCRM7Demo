package tests;

import dto.Account;
import helpers.AccountFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class NewAccountTest extends BaseTest {

    Account account = AccountFactory.getAccount("Investor", "Banking", "0");

    @Test
    public void checkAddNewAccount() throws InterruptedException {
        loginStep.authorization("will", "will");
        createAccountStep.createAccount(account);
        checkNewAccountStep.matchingAccount(account);
    }
}
