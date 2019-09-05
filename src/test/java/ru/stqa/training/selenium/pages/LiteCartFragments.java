package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LiteCartFragments {


    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public LiteCartProduct liteCartProductSetObject(WebElement product) {
        LiteCartProduct liteCartProduct = new LiteCartProduct();
        WebElement productPriceElement = product.findElement(By.cssSelector("div.price-wrapper>*.regular-price"));
        WebElement productDiscountedPriceElement = product.findElement(By.cssSelector("div.price-wrapper>*.campaign-price"));

        liteCartProduct.setProductName(product.findElement(By.cssSelector("div.name,h1.title")).getAttribute("textContent"));
        liteCartProduct.setProductPrice(productPriceElement.getAttribute("textContent"));
        liteCartProduct.setProductDiscountedPrice(productDiscountedPriceElement.getAttribute("textContent"));
        liteCartProduct.setProductPriceColor(productPriceElement.getCssValue("color"));
        liteCartProduct.setProductDiscountedPriceColor(productDiscountedPriceElement.getCssValue("color"));

        if (productPriceElement.getTagName().equals("s") || productPriceElement.getTagName().equals("del")) {
            liteCartProduct.setProductPriceStrikethrough(true);
        }

        if (productPriceElement.getTagName().equals("strong") || productPriceElement.getTagName().equals("b")) {
            liteCartProduct.setProductDiscountedPriceBold(true);
        }
        liteCartProduct.setProductPriceSize(productPriceElement.getCssValue("font-size"));
        liteCartProduct.setProductDiscountedPriceSize(productDiscountedPriceElement.getCssValue("font-size"));
        return liteCartProduct;
    }

    public void selectItemFromDropDown(By dropDownLocator, String optionName) {
        driver.findElement(dropDownLocator).click();
        driver.findElement(By.xpath("//option[contains(.,'" + optionName + "')]")).click();
    }


    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public void waitElementAppeared(By locator) {
        wait.until(presenceOfElementLocated(locator));
    }

    public void openCheckOutPage() {
        driver.findElement(By.cssSelector("div#cart a.link")).click();
    }
}
