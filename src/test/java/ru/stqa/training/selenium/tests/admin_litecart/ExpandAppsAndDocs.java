package ru.stqa.training.selenium.tests.admin_litecart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

public class ExpandAppsAndDocs extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;

    @BeforeMethod
    public void start() {
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
    }

    @Test
    public void ExpandAppsAndDocs() {
        liteCartAdminPage.clickOnFirstApp()
                .clickAndCheckEachApp();
    }
}
