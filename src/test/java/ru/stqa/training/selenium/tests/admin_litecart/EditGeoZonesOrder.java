package ru.stqa.training.selenium.tests.admin_litecart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

import java.util.List;

public class EditGeoZonesOrder extends TestBase {
    private LiteCartAdminPage liteCartAdminPage;

    @BeforeMethod
    public void before(){
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
    }

    @Test
    public void editGeoZonesOrder() {
        liteCartAdminPage.openGeoZonesApp();
        List<String> countriesWithZonesUrls = liteCartAdminPage.getZones();

        for (String zoneUrl:countriesWithZonesUrls) {
            liteCartAdminPage.openCustomLink(zoneUrl);
            List<String> countries = liteCartAdminPage.getZonesInMenu();
            Assert.assertTrue(liteCartAdminPage.isSorted(countries));
        }
    }
}

