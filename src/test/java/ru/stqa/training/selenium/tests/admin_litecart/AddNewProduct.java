package ru.stqa.training.selenium.tests.admin_litecart;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

public class AddNewProduct extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;

    @BeforeMethod
    public void before() {
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
    }

    @Test
    public void addNewProduct() {

        liteCartAdminPage.openCatalogApp()
                .clickAddNewProductButton()
                .fillInVaderDuckDetails()
                .clickSaveButton();


    }


}
