package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CheckDucks extends TestBase {
    public static String PRODUCT_LOCATOR = "li.product";
    public static String PRODUCT_STICKER_LOCATOR = "div[class*=sticker]";

    @Test
    public void checkDucks() {
        driver.get("http://localhost/litecart");
        List<WebElement> allDucks = driver.findElements(By.cssSelector(PRODUCT_LOCATOR));
        for (WebElement duck:allDucks){
            List<WebElement> duckStickers = duck.findElements(By.cssSelector(PRODUCT_STICKER_LOCATOR));
            Assert.assertTrue(duckStickers.size()==1);
        }
    }
}
