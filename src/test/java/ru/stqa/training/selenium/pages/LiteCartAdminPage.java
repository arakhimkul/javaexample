package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LiteCartAdminPage {

    private static String COUNTRIES_PAGE = "http://localhost/litecart/admin/?app=countries&doc=countries";
    private static String CATALOG_PAGE = "http://localhost/litecart/admin/?app=catalog&doc=catalog";
    private static String GEO_ZONES_PAGE = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";
    private static String NEXT_TO_OPEN_ITEM_XPATH = "(//li[contains(@class,'selected')])[last()]/following::li";
    private static String APP_ITEM_CSS = "li#app-";
    private static String GOOD_CONTENT = "h1";

    private WebDriver driver = DriverHolder.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
            Assert.assertTrue(new LiteCartFragments().isElementPresent(By.cssSelector(GOOD_CONTENT)));
        } while (driver.findElements(By.xpath(NEXT_TO_OPEN_ITEM_XPATH)).size() != 0);
        return this;
    }

    public LiteCartAdminPage openCountriesApp() {
        driver.get(COUNTRIES_PAGE);
        return this;
    }

    public LiteCartAdminPage addNewCountry() {
        driver.findElement(By.cssSelector("a.button")).click();
        return this;
    }

    public LiteCartAdminPage openCatalogApp() {
        driver.get(CATALOG_PAGE);
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
        List<String> items = new ArrayList<>();
        List<WebElement> rows = getRows();
        for (WebElement row : rows) {
            WebElement cellValue = row.findElement(By.cssSelector("td:nth-of-type(" + columnNumber + ")"));
            if (!cellValue.getAttribute("textContent").equals("")) {
                items.add(cellValue.getAttribute("textContent"));
            }
        }
        return items;
    }

    public List<String> getZones() {
        List<String> items = new ArrayList<>();
        List<WebElement> rows = getRows();
        int columnNumber = getHeaderColumnNumber("Zones");
        int UrlColumnNumber = columnNumber - 1;
        for (WebElement row : rows) {
            WebElement cellValue = row.findElement(By.cssSelector("td:nth-of-type(" + columnNumber + ")"));
            if (!cellValue.getAttribute("textContent").equals("0")) {
                items.add(row.findElement(By.cssSelector("td:nth-of-type(" + UrlColumnNumber + ") a")).getAttribute("href"));
            }
        }
        return items;
    }

    public List<String> getZonesInMenu() {
        int columnNumber = getHeaderColumnNumber("Zone");
        List<String> items = new ArrayList<>();
        List<WebElement> rows = getRows();
        for (WebElement row : rows) {
            if (!(row.findElement(By.cssSelector("td")).getAttribute("colspan") == null)) {
                continue;
            }
            WebElement cellValue = row.findElement(By.cssSelector("td:nth-of-type(" + columnNumber + ")>select>option[selected='selected']"));
            if (!cellValue.getAttribute("textContent").equals("")) {
                items.add(cellValue.getAttribute("textContent"));
            }
        }
        return items;
    }

    public boolean isSorted(List<String> list) {
        for (int a = 0; a < list.size() - 1; a++) {
            if (list.get(a).compareTo(list.get(a + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public LiteCartAdminPage clickAddNewProductButton() {
        driver.findElement(By.xpath("//a[contains(.,' Add New Product')]")).click();
        return this;
    }

    public LiteCartAdminPage clickSaveButton() {
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Save')]")).click();
        return this;
    }

    public LiteCartAdminPage fillInVaderDuckDetails() {
        wait.until(presenceOfElementLocated(By.xpath("//h1[contains(.,' Add New Product')]")));
        changeStatusToEnabled();
        addProductName("Vader duck");
//        wait();
        setProductQuantity(5);
        addProductImage("vader_duck.png");
        clickInformationTab();
        wait.until(presenceOfElementLocated(By.xpath("//li[@class='active'][contains(.,'Information')]")));
        selectManufacturer("ACME Corp.");
        clickPricesTab();
        wait.until(presenceOfElementLocated(By.xpath("//li[@class='active'][contains(.,'Prices')]")));
        setProductPurchasePrice(10);
        setProductPurchaseCurrency("US Dollars");
        setProductPrice(20);
        return this;
    }

    private LiteCartAdminPage setProductPurchaseCurrency(String currency) {
        new LiteCartFragments().selectItemFromDropDown(By.cssSelector("select[name='purchase_price_currency_code']"), currency);
        return this;
    }


    private LiteCartAdminPage selectManufacturer(String optionName) {
        new LiteCartFragments().selectItemFromDropDown(By.cssSelector("select[name='manufacturer_id']"), optionName);
        return this;
    }




    private LiteCartAdminPage clickInformationTab() {
        driver.findElement(By.xpath("//a[contains(.,'Information')]")).click();
        return this;
    }

    private LiteCartAdminPage clickPricesTab() {
        driver.findElement(By.xpath("//a[contains(.,'Prices')]")).click();

        return this;
    }

    private LiteCartAdminPage setProductQuantity(int number) {
        WebElement entryField = driver.findElement(By.cssSelector("input[name='quantity']"));
        entryField.clear();
        entryField.sendKeys(String.valueOf(number));
        return this;

    }

    private LiteCartAdminPage setProductPurchasePrice(int number) {
        WebElement entryField = driver.findElement(By.cssSelector("input[name='purchase_price']"));
        entryField.clear();
        entryField.sendKeys(String.valueOf(number));
        return this;
    }


    private LiteCartAdminPage setProductPrice(int number) {
        WebElement entryField = driver.findElement(By.cssSelector("input[name='prices[USD]']"));
        entryField.clear();
        entryField.sendKeys(String.valueOf(number));
        return this;
    }

    private LiteCartAdminPage addProductName(String productName) {
        driver.findElement(By.cssSelector("input[name*='name[']")).sendKeys(productName);
        return this;
    }


    private LiteCartAdminPage changeStatusToEnabled() {
        WebElement checkBoxEnabled = driver.findElement(By.xpath("//label[contains(.,'Enabled')]/input[@type='radio']"));
        Boolean statusIsEnabled = "true".equals(checkBoxEnabled.getAttribute("checked"));
        if (!statusIsEnabled) {
            checkBoxEnabled.click();
        }
        return this;
    }

    private LiteCartAdminPage addProductImage(String imageName) {
        String path = getUploadUrl(imageName);
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(path);
        return this;
    }

    private String getUploadUrl(String imageName) {
        return Paths.get("src/test/resources/" + imageName).toAbsolutePath().toString();
    }


    boolean isElementNotPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return driver.findElements(locator).size() == 0;
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
