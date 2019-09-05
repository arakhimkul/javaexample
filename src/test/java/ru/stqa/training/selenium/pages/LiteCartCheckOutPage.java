package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.base.DriverHolder;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;


public class LiteCartCheckOutPage {

    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public LiteCartCheckOutPage removeAllProducts() {
        By thumbnailLocator = By.cssSelector("li.shortcut");
        By orderTableRowsLocator = By.cssSelector("table.dataTable tr");
        By removeButtonLocator = By.cssSelector("button[name='remove_cart_item']");

        while (new LiteCartFragments().isElementPresent(orderTableRowsLocator)) {
            List<WebElement> tableRows = driver.findElements(orderTableRowsLocator);

            if (new LiteCartFragments().isElementPresent(thumbnailLocator)) {
                driver.findElement(thumbnailLocator).click();
            }

            wait.until(elementToBeClickable(removeButtonLocator));
            driver.findElement(removeButtonLocator).click();

            wait.until(numberOfElementsToBeLessThan(orderTableRowsLocator, tableRows.size()));
        }
        return this;
    }

}
