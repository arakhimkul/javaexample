package ru.stqa.training.selenium.tests.admin_litecart;

import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

public class LiteCartAdminLogin extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;

    @Test
    public void liteCartAdminLogin() {
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
    }
}
