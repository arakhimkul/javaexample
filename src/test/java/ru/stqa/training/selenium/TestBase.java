package ru.stqa.training.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

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


        wait = new WebDriverWait(driver, 10);

    }

//    public boolean isElementPresent(By locator){
//        try{
//            driver.findElement(locator);
//            return true;
//        } catch (TimeoutException ex){
//            return false;
//        }
//
//    }

    public boolean isElementPresent(By locator){
        if(driver.findElements(locator).size()!=0){
            return true;
        }
        return false;
    }



    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

    }

    @AfterClass
    public void stop() {
        driver.quit();
        driver = null;
    }

}
