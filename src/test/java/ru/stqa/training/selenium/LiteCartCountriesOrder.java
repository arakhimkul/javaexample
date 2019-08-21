package ru.stqa.training.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LiteCartCountriesOrder extends TestBase {

    @BeforeMethod
    public void before(){
        login();
    }

    @Test
    public void LiteCartCountriesOrder() {
        driver.get(COUNTRIES_PAGE);
        List<String> countries = getNames();
        Assert.assertTrue(isSorted(countries));
    }
}
