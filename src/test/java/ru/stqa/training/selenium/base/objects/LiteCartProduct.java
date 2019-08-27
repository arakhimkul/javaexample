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

    public boolean getProductPriceStrikethrough() {
        return productPriceStrikethrough;
    }

    public void setProductPriceStrikethrough(boolean productPriceStrikethrough) {
        this.productPriceStrikethrough = productPriceStrikethrough;
    }

    public boolean getProductDiscountedPriceBold() {
        return productDiscountedPriceBold;
    }

    public void setProductDiscountedPriceBold(boolean productDiscountedPriceBold) {
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
    public boolean productPriceStrikethrough;
    public boolean productDiscountedPriceBold;
    public String productPriceSize;
    public String productDiscountedPriceSize;
}
