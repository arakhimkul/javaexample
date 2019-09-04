package ru.stqa.training.selenium.tests.admin_litecart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;
import ru.stqa.training.selenium.pages.LiteCartEditCountryPage;

public class EditCountryInNewWindow extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;
    private LiteCartEditCountryPage liteCartEditCountryPage;

    @BeforeMethod
    public void before(){
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
        liteCartEditCountryPage = new LiteCartEditCountryPage();
    }

    @Test
    public void eEditCountryInNewWindow() {
        liteCartAdminPage.openCountriesApp()
                .addNewCountry();
        liteCartEditCountryPage.openAndCloseEachFormLink();

    }
}
