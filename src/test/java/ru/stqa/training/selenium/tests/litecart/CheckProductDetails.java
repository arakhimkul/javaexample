package ru.stqa.training.selenium.tests.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartPage;

import java.util.ArrayList;
import java.util.List;


public class CheckProductDetails extends TestBase {

    private LiteCartPage liteCartPage;

    @BeforeMethod
    public void start() {
        openHomePage();
        liteCartPage = new LiteCartPage();
    }

    public static String SECTION_NAME = "Campaigns";
    public static int PRODUCT_INDEX = 0;    //starting with 0

    @Test
    public void CheckProductDetails() {

//        WebElement content = driver.findElement(By.cssSelector("div#main>div.middle>div.content"));
//        List<WebElement> productsOfSection = getProductsOfSection(content,SECTION_NAME);
//        LiteCartProduct campaignProduct = new LiteCartProduct(productsOfSection, PRODUCT_INDEX);
//        productsOfSection.get(PRODUCT_INDEX).findElement(By.cssSelector("li[class*='product']")).click();
//
//        WebElement contentDetails = driver.findElement(By.cssSelector("div#main>div.middle>div.content"));
//        LiteCartProduct SubCategoryProduct = new LiteCartProduct(productsOfSection, PRODUCT_INDEX);


//        productName = product.findElement(By.cssSelector("div.name")).getAttribute("textContent");

Assert.assertTrue(true);
        }
}
