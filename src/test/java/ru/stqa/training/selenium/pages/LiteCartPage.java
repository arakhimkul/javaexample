package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;

import java.util.ArrayList;
import java.util.List;

public class LiteCartPage {

    public static String PRODUCT_LOCATOR = "li.product";
    public static String PRODUCT_STICKER_LOCATOR = "div[class*=sticker]";

    private WebDriver driver = DriverHolder.getDriver();

    public LiteCartPage checkProductsHaveStickers() {
        List<WebElement> allProducts = driver.findElements(By.cssSelector(PRODUCT_LOCATOR));
        for (WebElement product : allProducts) {
            List<WebElement> productStickers = product.findElements(By.cssSelector(PRODUCT_STICKER_LOCATOR));
            Assert.assertEquals(1, productStickers.size());
        }
        return this;
    }

    private List<WebElement> getProductsOfSection(WebElement productSection, String sectionName) {
        List<WebElement> sections = productSection.findElements(By.cssSelector("div[id*='box-'][class=box]"));
        List<WebElement> productsInSection = new ArrayList<WebElement>();
        for (WebElement section : sections) {
            if (section.findElement(By.cssSelector("h3.title,h1.title")).getAttribute("textContent").equals(sectionName)) {
                productsInSection.add(section);
            }
        }
        return productsInSection;
    }

    public LiteCartProduct getProductObjectFromHomePage(String sectionName, int productNumber) {
        WebElement content = driver.findElement(By.cssSelector("div#main>div.middle>div.content"));
        List<WebElement> productsOfSection = getProductsOfSection(content, sectionName);
        WebElement product = productsOfSection.get(productNumber);
        return new LiteCartFragments().liteCartProductSetObject(product);

    }

    public LiteCartPage clickOnItemInSectionByIndex(String sectionName, int index) {
        int productNumber = index + 1;
        driver.findElement(By.xpath("//h3[contains(.,'" + sectionName + "')]/..//li["+productNumber+"]")).click();
        return this;
    }


    public LiteCartPage clickCreateAccountLink() {
        driver.findElement(By.xpath("//a[contains(.,'Create Account')]/..")).click();
        return this;
    }
}
