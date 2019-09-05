package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;


public class LiteCartSubcategoryPage {

    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public LiteCartProduct getProductObjectFromSubcategoryPage() {
        List<WebElement> productsOfSection = driver.findElements(By.cssSelector("div#main>div.middle>div.content>div.box"));
        WebElement product = productsOfSection.get(0);
        return new LiteCartFragments().liteCartProductSetObject(product);
    }


    public LiteCartSubcategoryPage addFirstItemToCart() {
        if (new LiteCartFragments().isElementPresent(By.cssSelector("select[name='options[Size]']"))) {
            new LiteCartFragments().selectItemFromDropDown(By.cssSelector("select[name='options[Size]']"), "Small");
        }
        By locator = By.cssSelector("div#cart span.quantity");
        clickAddToCart();
        waitCartIsUpdated(locator);
        return this;
    }

    private LiteCartSubcategoryPage clickAddToCart() {
        driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        return this;
    }


    private LiteCartSubcategoryPage waitCartIsUpdated(By locator) {

        wait.until(not(textToBe(locator, driver.findElement(locator).getText())));

        return this;
    }


}
