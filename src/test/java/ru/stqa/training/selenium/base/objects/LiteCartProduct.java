package ru.stqa.training.selenium.base.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.base.TestBase;

import java.util.List;


public class LiteCartProduct extends TestBase {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(String productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }

    public String getProductPriceColor() {
        return productPriceColor;
    }

    public void setProductPriceColor(String productPriceColor) {
        this.productPriceColor = productPriceColor;
    }

    public String getProductDiscountedPriceColor() {
        return productDiscountedPriceColor;
    }

    public void setProductDiscountedPriceColor(String productDiscountedPriceColor) {
        this.productDiscountedPriceColor = productDiscountedPriceColor;
    }

    public String getProductPriceStrikethrough() {
        return productPriceStrikethrough;
    }

    public void setProductPriceStrikethrough(String productPriceStrikethrough) {
        this.productPriceStrikethrough = productPriceStrikethrough;
    }

    public String getProductDiscountedPriceBold() {
        return productDiscountedPriceBold;
    }

    public void setProductDiscountedPriceBold(String productDiscountedPriceBold) {
        this.productDiscountedPriceBold = productDiscountedPriceBold;
    }

    public String getProductPriceSize() {
        return productPriceSize;
    }

    public void setProductPriceSize(String productPriceSize) {
        this.productPriceSize = productPriceSize;
    }

    public String getProductDiscountedPriceSize() {
        return productDiscountedPriceSize;
    }

    public void setProductDiscountedPriceSize(String productDiscountedPriceSize) {
        this.productDiscountedPriceSize = productDiscountedPriceSize;
    }

    public String productName;
    public String productPrice;
    public String productDiscountedPrice;
    public String productPriceColor;
    public String productDiscountedPriceColor;
    public String productPriceStrikethrough;
    public String productDiscountedPriceBold;
    public String productPriceSize;
    public String productDiscountedPriceSize;





//    public LiteCartProduct(List<WebElement> productsInSection, int productNumber) {
//        WebElement product = productsInSection.get(productNumber);
//        productName = product.findElement(By.cssSelector("div.name,h1.title")).getAttribute("textContent");
//
//        WebElement productPriceElement = product.findElement(By.cssSelector("div.price-wrapper>*.regular-price"));
//        WebElement productDiscountedPriceElement = product.findElement(By.cssSelector("div.price-wrapper>*.campaign-price"));
//
//        productPrice = productPriceElement.getAttribute("textContent");
//        productDiscountedPrice = productDiscountedPriceElement.getAttribute("textContent");
//
//        productPriceColor = productPriceElement.getCssValue("color");
//        productDiscountedPriceColor = productDiscountedPriceElement.getCssValue("color");
//
//        productPriceStrikethrough = productPriceElement.getTagName();
//        productDiscountedPriceBold = productDiscountedPriceElement.getTagName();
//
//        productPriceSize = productPriceElement.getCssValue("font-size");
//        productDiscountedPriceSize = productDiscountedPriceElement.getCssValue("font-size");
//    }

}
