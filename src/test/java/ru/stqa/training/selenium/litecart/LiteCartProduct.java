package ru.stqa.training.selenium.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.TestBase;

import java.util.ArrayList;
import java.util.List;


public class LiteCartProduct extends TestBase {
    public String productName;
    public String productPrice;
    public String productDiscountedPrice;
    public String productPriceColor;
    public String productDiscountedPriceColor;
    public String productPriceStrikethrough;
    public String productDiscountedPriceBold;

    public String productPriceSize;
    public String productDiscountedPriceSize;




    public LiteCartProduct(List<WebElement> productsInSection, int productNumber) {
        WebElement product = productsInSection.get(productNumber-1);
        productName = product.findElement(By.cssSelector("div.name")).getAttribute("textContent");

        WebElement productPriceElement = product.findElement(By.cssSelector("div.price-wrapper>*.regular-price"));
        WebElement productDiscountedPriceElement = product.findElement(By.cssSelector("div.price-wrapper>*.campaign-price"));

        productPrice = productPriceElement.getAttribute("textContent");
        productDiscountedPrice = productDiscountedPriceElement.getAttribute("textContent");

        productPriceColor = productPriceElement.getCssValue("color");
        productDiscountedPriceColor = productDiscountedPriceElement.getCssValue("color");

        productPriceStrikethrough = productPriceElement.getTagName();
        productDiscountedPriceBold = productDiscountedPriceElement.getTagName();

        productPriceSize = productPriceElement.getCssValue("font-size");
        productDiscountedPriceSize = productDiscountedPriceElement.getCssValue("font-size");
    }
}
