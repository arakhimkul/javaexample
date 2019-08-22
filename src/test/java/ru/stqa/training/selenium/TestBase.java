package ru.stqa.training.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static String COUNTRIES_PAGE = "http://localhost/litecart/admin/?app=countries&doc=countries";
    protected static String GEO_ZONES_PAGE = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

//        WebDriverManager.iedriver().setup();
//        driver = new InternetExplorerDriver();

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options
//                .setLegacy(true)
//                .setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
//        driver = new FirefoxDriver(options);


        wait = new WebDriverWait(driver, 1);
    }

    public boolean isElementPresent(By locator){
        if(driver.findElements(locator).size()!=0){
            return true;
        }
        return false;
    }

    public boolean isSorted(List<String> list)
    {
        for(int a=0;a<list.size()-1;a++)
        {
            if(list.get(a).compareTo(list.get(a+1))>0)
            {
                return false;
            }
        }
        return true;
    }

    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }


    public int getHeaderColumnNumber(String columnName) {
        List<WebElement> headers = driver.findElements(By.cssSelector("table tr.header th"));
        for (int arraySize = 0; arraySize < headers.size(); arraySize++) {
            if (headers.get(arraySize).getText().equals(columnName)) {
                return arraySize + 1;
            }
        }
        return 0;
    }

    public List<WebElement> getRows() {
        return driver.findElements(By.cssSelector("table.dataTable tr:not(.header):not(.footer)"));
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

    @AfterClass
    public void stop() {
        driver.quit();
        driver = null;
    }

}
