package ru.stqa.training.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LiteCartEditGeoZonesOrder extends TestBase {

    @BeforeMethod
    public void before(){
        login();
    }

    @Test
    public void LiteCartEditGeoZonesOrder() {
        driver.get(GEO_ZONES_PAGE);
        List<String> countriesWithZonesUrls = getZones();

        for (String Url:countriesWithZonesUrls) {
            driver.get(Url);
            List<String> countries = getZonesInMenu();
            Assert.assertTrue(isSorted(countries));
        }
    }
}

