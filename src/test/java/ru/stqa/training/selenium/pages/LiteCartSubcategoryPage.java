package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;

import java.util.ArrayList;
import java.util.List;

public class LiteCartSubcategoryPage {

    private WebDriver driver = DriverHolder.getDriver();


    public LiteCartProduct getProductObjectFromSubcategoryPage() {
        List<WebElement> productsOfSection = driver.findElements(By.cssSelector("div#main>div.middle>div.content>div.box"));
        WebElement product = productsOfSection.get(0);
        return new LitecartFragments().liteCartProductSetObject(product);
    }


}