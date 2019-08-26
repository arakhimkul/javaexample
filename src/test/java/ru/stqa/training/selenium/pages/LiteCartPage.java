package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;

import java.util.ArrayList;
import java.util.List;

public class LiteCartPage {

    public static String PRODUCT_LOCATOR = "li.product";
    public static String PRODUCT_STICKER_LOCATOR = "div[class*=sticker]";

    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public LiteCartPage checkProductsHaveStickers() {
        List<WebElement> allProducts = driver.findElements(By.cssSelector(PRODUCT_LOCATOR));
        for (WebElement product : allProducts) {
            List<WebElement> productStickers = product.findElements(By.cssSelector(PRODUCT_STICKER_LOCATOR));
            Assert.assertTrue(productStickers.size() == 1);
        }
        return this;
    }

    public List<WebElement> getProductsOfSection(WebElement productSection, String sectionName){
        List<WebElement> sections = productSection.findElements(By.cssSelector("div[id*='box-'][class=box]"));
        List<WebElement> productsInSection = new ArrayList<WebElement>();
        for (WebElement section:sections){
            if (section.findElement(By.cssSelector("h3.title,h1.title")).getAttribute("textContent").equals(sectionName)) {
                productsInSection.add(section);
            }
        } return productsInSection;
    }
}
