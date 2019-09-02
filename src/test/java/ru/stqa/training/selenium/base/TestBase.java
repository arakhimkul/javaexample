package ru.stqa.training.selenium.base;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private static String LITECART_HOME_PAGE_URL = "http://localhost/litecart";
    private static String LITECART_ADMIN_HOME_PAGE_URL = "http://localhost/litecart/admin/";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        String driverName = System.getProperty("webdriver.name");
        DriverManagerType managerType = DriverManagerType.valueOf(driverName);
        WebDriverManager.getInstance(managerType).setup();

        DriverHolder.setDriver(managerType);
        driver = DriverHolder.getDriver();
    }

    protected void openAdminHomePage() {
        driver.get(LITECART_ADMIN_HOME_PAGE_URL);
    }

    protected void openHomePage() {
        driver.get(LITECART_HOME_PAGE_URL);
    }


    @AfterClass
    public void stop() {
        driver.quit();
        driver = null;
    }
}
