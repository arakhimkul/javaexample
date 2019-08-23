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
    public String productPriceSize;
    public String productDiscountedPriceSize;




    public LiteCartProduct(List<WebElement> productsInSection, int productNumber) {
        WebElement product = productsInSection.get(productNumber-1);
        productName = product.findElement(By.cssSelector("div.name")).getAttribute("textContent");
        productPrice = product.findElement(By.cssSelector("div.price-wrapper>s.regular-price")).getAttribute("textContent");
        productDiscountedPrice = product.findElement(By.cssSelector("div.price-wrapper>strong.campaign-price")).getAttribute("textContent");
        productPriceColor = product.findElement(By.cssSelector("div.price-wrapper>s.regular-price")).getAttribute("textContent");


    }
}
