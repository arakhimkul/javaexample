package ru.stqa.training.selenium.base;

import com.beust.jcommander.ParameterException;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverHolder {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal();


    public DriverHolder() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(DriverManagerType driverManagerType) {
        switch (driverManagerType) {
            case CHROME:
                driver.set(new ChromeDriver());
                break;
            case FIREFOX:
                driver.set(new FirefoxDriver());
                break;
            case OPERA:
                driver.set(new OperaDriver());
                break;
            case IEXPLORER:
                driver.set(new InternetExplorerDriver());
                break;
            case EDGE:
                driver.set(new EdgeDriver());
                break;
            default:
                throw new ParameterException("Unsupported browser");
        }
        driver.get().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }
}

