package ru.stqa.training.selenium.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.TestBase;

import java.util.ArrayList;
import java.util.List;


public class CheckProductDetails extends TestBase {
    public static String SECTION_NAME = "Campaigns";
    public static int PRODUCT_NUMBER = 1;

    @Test
    public void CheckProductDetails() {
        driver.get(LITECART_HOME_PAGE);

        WebElement content = driver.findElement(By.cssSelector("div#main>div.middle>div.content"));
        List<WebElement> productsOfSection = getProductsOfSection(content,SECTION_NAME);
        LiteCartProduct campaignProduct = new LiteCartProduct(productsOfSection,PRODUCT_NUMBER);

Assert.assertTrue(true);
        }

    public List<WebElement> getProductsOfSection(WebElement productSection, String sectionName){
        List<WebElement> sections = productSection.findElements(By.cssSelector("div[id*='box-'][class=box]"));
        List<WebElement> productsInSection = new ArrayList<WebElement>();
        for (WebElement section:sections){
            if (section.findElement(By.cssSelector("h3.title")).getAttribute("textContent").equals(sectionName)) {
                productsInSection = section.findElements(By.cssSelector("div.content"));
            }
        } return productsInSection;
    }

}
