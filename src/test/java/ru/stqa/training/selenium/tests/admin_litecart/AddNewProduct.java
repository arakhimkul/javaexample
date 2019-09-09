package ru.stqa.training.selenium.tests.admin_litecart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddNewProduct extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;
    private List<String> productNames = Arrays.asList("Joker", "Vader", "Batman");
    private int randomInt = ThreadLocalRandom.current().nextInt(0, 2);

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
                .fillInNewDuckDetails(productNames.get(randomInt))
                .clickSaveButton()
                .checkProductAppeared(productNames.get(randomInt));


    }


}
