package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LiteCartAdminPage {

    private static String COUNTRIES_PAGE = "http://localhost/litecart/admin/?app=countries&doc=countries";
    private static String GEO_ZONES_PAGE = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";
    private static String NEXT_TO_OPEN_ITEM_XPATH = "(//li[contains(@class,'selected')])[last()]/following::li";
    private static String APP_ITEM_CSS = "li#app-";
    private static String GOOD_CONTENT = "h1";

    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public LiteCartAdminPage login() {
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        return this;
    }

    public LiteCartAdminPage clickOnFirstApp() {
        driver.findElement(By.cssSelector(APP_ITEM_CSS)).click(); // Expanding the first item to click one-by-one afterwards
        return this;
    }

    public LiteCartAdminPage clickAndCheckEachApp() {
        do {
            driver.findElement(By.xpath(NEXT_TO_OPEN_ITEM_XPATH)).click();
            Assert.assertTrue(isElementPresent(By.cssSelector(GOOD_CONTENT)));
        } while (driver.findElements(By.xpath(NEXT_TO_OPEN_ITEM_XPATH)).size() != 0);
        return this;
    }

    public LiteCartAdminPage openCountriesApp() {
        driver.get(COUNTRIES_PAGE);
        return this;
    }

    public LiteCartAdminPage openGeoZonesApp() {
        driver.get(GEO_ZONES_PAGE);
        return this;
    }

    public LiteCartAdminPage openCustomLink(String Url) {
        driver.get(Url);
        return this;
    }

    public int getHeaderColumnNumber(String columnName) {
        List<WebElement> headers = DriverHolder.getDriver().findElements(By.cssSelector("table tr.header th"));
        for (int arraySize = 0; arraySize < headers.size(); arraySize++) {
            if (headers.get(arraySize).getText().equals(columnName)) {
                return arraySize + 1;
            }
        }
        return 0;
    }

    public List<WebElement> getRows() {
        return DriverHolder.getDriver().findElements(By.cssSelector("table.dataTable tr:not(.header):not(.footer)"));
    }

    public List<String> getNames() {
        int columnNumber = getHeaderColumnNumber("Name");
        List<String> items = new ArrayList<String>();
        List<WebElement> rows = getRows();
        for (WebElement row:rows) {
            WebElement cellValue = row.findElement(By.cssSelector("td:nth-of-type(" + columnNumber + ")"));
            if (!cellValue.getAttribute("textContent").equals("")) {
                items.add(cellValue.getAttribute("textContent"));
            }
        } return items;
    }

    public List<String> getZones() {
        List<String> items = new ArrayList<String>();
        List<WebElement> rows = getRows();
        int columnNumber = getHeaderColumnNumber("Zones");
        int UrlColumnNumber = columnNumber-1;
        for (WebElement row:rows) {
            WebElement cellValue = row.findElement(By.cssSelector("td:nth-of-type(" + columnNumber + ")"));
            if (!cellValue.getAttribute("textContent").equals("0")) {
                items.add(row.findElement(By.cssSelector("td:nth-of-type(" + UrlColumnNumber + ") a")).getAttribute("href"));
            }
        } return items;
    }

    public List<String> getZonesInMenu() {
        int columnNumber = getHeaderColumnNumber("Zone");
        List<String> items = new ArrayList<String>();
        List<WebElement> rows = getRows();
        for (WebElement row:rows) {
            if (!(row.findElement(By.cssSelector("td")).getAttribute("colspan") ==null)){
                continue;
            }
            WebElement cellValue = row.findElement(By.cssSelector("td:nth-of-type(" + columnNumber + ")>select>option[selected='selected']"));
            if (!cellValue.getAttribute("textContent").equals("")) {
                items.add(cellValue.getAttribute("textContent"));
            }
        } return items;
    }

    public boolean isSorted(List<String> list) {
        for (int a = 0; a < list.size() - 1; a++) {
            if (list.get(a).compareTo(list.get(a + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }
}
