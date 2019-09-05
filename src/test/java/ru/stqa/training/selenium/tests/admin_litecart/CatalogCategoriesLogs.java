package ru.stqa.training.selenium.tests.admin_litecart;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.pages.LiteCartAdminPage;

import java.util.List;

public class CatalogCategoriesLogs extends TestBase {

    private LiteCartAdminPage liteCartAdminPage;

    @BeforeMethod
    public void before() {
        openAdminHomePage();
        liteCartAdminPage = new LiteCartAdminPage();
        liteCartAdminPage.login();
    }

    @Test
    public void catalogCategoriesLogs() {
        liteCartAdminPage.openCatalogCategories().clickEachProduct();
        LogEntries logPointer = DriverHolder.getDriver().manage().logs().get("browser");
        List<LogEntry> logs = logPointer.getAll();
        Assert.assertEquals(logs.size(),0);
        System.out.println(logs);
    }
}
