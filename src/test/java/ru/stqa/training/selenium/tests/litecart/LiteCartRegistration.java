package ru.stqa.training.selenium.tests.litecart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.base.objects.LiteCartUser;
import ru.stqa.training.selenium.pages.LiteCartCreateAccountPage;
import ru.stqa.training.selenium.pages.LiteCartPage;


public class LiteCartRegistration extends TestBase {

    private LiteCartPage liteCartPage;
    private LiteCartCreateAccountPage liteCartCreateAccountPage;

    @BeforeMethod
    public void start() {
        liteCartPage = new LiteCartPage();
        openHomePage();
    }

    @Test
    public void liteCartRegistration() {
        liteCartPage.clickCreateAccountLink();

        liteCartCreateAccountPage = new LiteCartCreateAccountPage();
        Assert.assertTrue(liteCartCreateAccountPage.isCaptchaDisabled());

        LiteCartUser liteCartUser = liteCartCreateAccountPage.getRandomUser();
        liteCartCreateAccountPage.fillInRequiredDetails(liteCartUser);


        liteCartCreateAccountPage.submitCreateAccountForm();


        liteCartPage = new LiteCartPage();
        liteCartPage.logout();


        liteCartPage = new LiteCartPage();
        liteCartPage.loginWithUser(liteCartUser);
    }


}
