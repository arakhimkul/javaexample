package ru.stqa.training.selenium.admin_litecart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.TestBase;

public class ExpandAppsAndDocs extends TestBase {
    public static String NEXT_TO_OPEN_ITEM_XPATH = "(//li[contains(@class,'selected')])[last()]/following::li";
    public static String APP_ITEM_CSS = "li#app-";
    public static String GOOD_CONTENT = "h1";

    @BeforeMethod
    public void start() {
        login();
    }

    @Test
    public void ExpandAppsAndDocs() {
        driver.findElement(By.cssSelector(APP_ITEM_CSS)).click(); // Expanding the first item to click one-by-one afterwards

        do{
            driver.findElement(By.xpath(NEXT_TO_OPEN_ITEM_XPATH)).click();
            Assert.assertTrue(isElementPresent(By.cssSelector(GOOD_CONTENT)));
        } while (driver.findElements(By.xpath(NEXT_TO_OPEN_ITEM_XPATH)).size()!=0);
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
