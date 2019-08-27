package ru.stqa.training.selenium.tests.litecart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;
import ru.stqa.training.selenium.pages.LiteCartPage;
import ru.stqa.training.selenium.pages.LiteCartSubcategoryPage;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;


public class CheckProductDetails extends TestBase {

    private LiteCartPage liteCartPage;
    private LiteCartSubcategoryPage liteCartSubcategoryPage;
    public static int PRODUCT_INDEX = 0;    //starting with 0

    @BeforeMethod
    public void start() {
        openHomePage();
        liteCartPage = new LiteCartPage();
        liteCartSubcategoryPage = new LiteCartSubcategoryPage();
    }

    @Test
    public void CheckProductDetails() {

        LiteCartProduct productObjectFromHomePage = liteCartPage.getProductObjectFromHomePage("Campaigns", PRODUCT_INDEX);
        liteCartPage.clickOnItemInSectionByIndex("Campaigns", PRODUCT_INDEX);
        LiteCartProduct productObjectFromSubcategory = liteCartSubcategoryPage.getProductObjectFromSubcategoryPage();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(productObjectFromHomePage.getProductName().equals(productObjectFromSubcategory.getProductName()));
            softly.assertThat(productObjectFromHomePage.getProductPrice().equals(productObjectFromSubcategory.getProductPrice()));
            softly.assertThat(productObjectFromHomePage.getProductDiscountedPrice().equals(productObjectFromSubcategory.getProductDiscountedPrice()));

        });


    }


}
