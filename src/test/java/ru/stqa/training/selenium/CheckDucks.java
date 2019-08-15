package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CheckDucks extends TestBase {

    @Test
    public void checkDucks() {
        driver.get("http://localhost/litecart");
        List<WebElement> allDucks = driver.findElements(By.cssSelector("div.image-wrapper"));
        for (WebElement duck:allDucks){
            List<WebElement> duckStickers = duck.findElements(By.cssSelector("div[class*=sticker]"));
            Assert.assertTrue(duckStickers.size()==1);
        }
    }
}
