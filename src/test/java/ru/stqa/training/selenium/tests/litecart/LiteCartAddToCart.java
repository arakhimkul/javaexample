package ru.stqa.training.selenium.tests.litecart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartCheckOutPage;
import ru.stqa.training.selenium.pages.LiteCartFragments;
import ru.stqa.training.selenium.pages.LiteCartPage;
import ru.stqa.training.selenium.pages.LiteCartSubcategoryPage;


public class LiteCartAddToCart extends TestBase {

    private LiteCartPage liteCartPage;
    private LiteCartSubcategoryPage liteCartSubcategoryPage;

    @BeforeMethod
    public void start() {
        liteCartPage = new LiteCartPage();
        liteCartSubcategoryPage = new LiteCartSubcategoryPage();
        openHomePage();
    }

    @Test
    public void liteCartAddToCart() {
        liteCartPage.openFirstProduct();
        liteCartSubcategoryPage.addFirstItemToCart();

        openHomePage();
        liteCartPage.openFirstProduct();
        liteCartSubcategoryPage.addFirstItemToCart();

        openHomePage();
        liteCartPage.openFirstProduct();
        liteCartSubcategoryPage.addFirstItemToCart();
        new LiteCartFragments().openCheckOutPage();
        LiteCartCheckOutPage liteCartCheckOut = new LiteCartCheckOutPage();
        liteCartCheckOut.removeAllProducts();
    }
}
