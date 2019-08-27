package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;

public class LitecartFragments {

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
}
