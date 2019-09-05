package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LiteCartEditCountryPage {

    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public LiteCartEditCountryPage openAndCloseEachFormLink() {
        List<WebElement> allFormHyperLinks = driver.findElements(By.cssSelector("form a[target='_blank']"));

        for (WebElement formHyperLink : allFormHyperLinks) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            formHyperLink.click();
            String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);

        }
        return this;
    }

    private ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows) {
        return input -> {
            Set<String> handles = input.getWindowHandles();
            handles.removeAll(oldWindows);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
    }


//    private ExpectedCondition<String> newWindowAppeared(Set<String> oldWindows) {
//        do {
//            Set<String> allWindows = driver.getWindowHandles();
//            allWindows.removeAll(oldWindows);
//            if (allWindows.size() > 0) {
//                return allWindows.iterator().next();
//            } else return null;
//        } while
//
//    }


}
