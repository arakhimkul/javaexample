package ru.stqa.training.selenium.tests.litecart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartPage;


public class CheckDucks extends TestBase {

    private LiteCartPage liteCartPage;

    @BeforeMethod
    public void start() {
        liteCartPage = new LiteCartPage();
        openHomePage();
    }

    @Test
    public void checkDucks() {
        liteCartPage.checkProductsHaveStickers();

    }
}
