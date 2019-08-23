package ru.stqa.training.selenium.admin_litecart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.TestBase;

import java.util.List;

public class LiteCartCountryZonesOrder extends TestBase {

    @BeforeMethod
    public void before(){
        login();
    }

    @Test
    public void LiteCartCountryZonesOrder() {
        driver.get(COUNTRIES_PAGE);
        List<String> countriesWithZonesUrls = getZones();

        for (String Url:countriesWithZonesUrls) {
            driver.get(Url);
            List<String> countries = getNames();
            Assert.assertTrue(isSorted(countries));
        }
    }
}
