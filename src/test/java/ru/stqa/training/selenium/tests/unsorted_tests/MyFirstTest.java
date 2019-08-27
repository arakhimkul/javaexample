package ru.stqa.training.selenium.tests.unsorted_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.TestBase;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends TestBase {

    @Test
    public void myFirstTest() {
        DriverHolder.getDriver().get("http://www.google.com");
        DriverHolder.getDriver().findElement(By.name("q")).sendKeys("webdriver");
        DriverHolder.getDriver().findElement(By.name("q")).sendKeys(Keys.RETURN); // Sending ENTER key
//        driver.findElement(By.name("btnG")).click();
        WebDriverWait wait = new WebDriverWait(DriverHolder.getDriver(), 5);
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
