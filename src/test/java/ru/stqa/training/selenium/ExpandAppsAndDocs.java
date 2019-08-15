package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpandAppsAndDocs extends TestBase {
    public static String nextToOpenItemXPath = "(//li[contains(@class,'selected')])[last()]/following::li";
    public static String appItemCss = "li#app-";
    public static String goodContent = "h1";

    @BeforeMethod
    public void start() {
        login();
    }

    @Test
    public void ExpandAppsAndDocs() {
        driver.findElement(By.cssSelector(appItemCss)).click(); // Expanding the first item to click one-by-one afterwards

        do{
            driver.findElement(By.xpath(nextToOpenItemXPath)).click();
            Assert.assertTrue(isElementPresent(By.cssSelector(goodContent)));
        } while (driver.findElements(By.xpath(nextToOpenItemXPath)).size()!=0);
    }


//    List<WebElement> allAppsAndDocs = ((ChromeDriver) driver).findElementsByCssSelector("li#app-");
//
//        for (int i = 1; i < allAppsAndDocs.size(); i++) {
////            ((ChromeDriver) driver).findElementByCssSelector("li#app-:nth-of-type("+i+")").click();
//        ((ChromeDriver) driver).findElementByXPath("(//li[contains(@class,'selected')])[last()]/following::li").click();
//        Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
//
////            ((ChromeDriver) driver).findElementByClassName("name").click();
//    }
//}


//    @AfterMethod
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }

}
