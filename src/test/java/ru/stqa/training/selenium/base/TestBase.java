package ru.stqa.training.selenium.base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;


public class TestBase {


    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by +  " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
            File tmp =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenShot = new File("screen-"+System.currentTimeMillis() + ".png");
            try {
                Files.copy(tmp, screenShot);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(screenShot);
        }
    }


    private static String LITECART_HOME_PAGE_URL = "http://localhost/litecart";
    private static String LITECART_ADMIN_HOME_PAGE_URL = "http://localhost/litecart/admin/";
    private EventFiringWebDriver driver;

    @BeforeMethod
    public void setup() {

        String driverName = System.getProperty("webdriver.name");
        DriverManagerType managerType = DriverManagerType.valueOf(driverName);
        WebDriverManager.getInstance(managerType).setup();

        DriverHolder.setDriver(managerType);
        driver = new EventFiringWebDriver(DriverHolder.getDriver());
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
