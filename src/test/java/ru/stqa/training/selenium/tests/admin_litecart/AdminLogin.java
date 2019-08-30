package ru.stqa.training.selenium.tests.admin_litecart;

import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

public class AdminLogin extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;

    @Test
    public void adminLogin() {
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
    }
}
