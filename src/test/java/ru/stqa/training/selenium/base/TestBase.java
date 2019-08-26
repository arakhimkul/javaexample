package ru.stqa.training.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private static String LITECART_HOME_PAGE_URL = "http://localhost/litecart";
    private static String LITECART_ADMIN_HOME_PAGE_URL = "http://localhost/litecart/admin/";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        DriverHolder.setDriver(new ChromeDriver());
        driver = DriverHolder.getDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        WebDriverManager.iedriver().setup();
//        driver = new InternetExplorerDriver();

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options
//                .setLegacy(true)
//                .setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
//        driver = new FirefoxDriver(options);

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
