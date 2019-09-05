package ru.stqa.training.selenium.base;

import com.beust.jcommander.ParameterException;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverHolder {

    private static ThreadLocal<EventFiringWebDriver> driver = new ThreadLocal();


    public DriverHolder() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(DriverManagerType driverManagerType) {
        EventFiringWebDriver eventWebDriver;
        switch (driverManagerType) {
            case CHROME:
                 eventWebDriver = new EventFiringWebDriver(new ChromeDriver());
                break;
            case FIREFOX:
                 eventWebDriver = new EventFiringWebDriver(new FirefoxDriver());
                break;
            case OPERA:
                eventWebDriver = new EventFiringWebDriver(new OperaDriver());
                break;
            case IEXPLORER:
                eventWebDriver = new EventFiringWebDriver(new InternetExplorerDriver());
                break;
            case EDGE:
                eventWebDriver = new EventFiringWebDriver(new EdgeDriver());
                break;
            default:
                throw new ParameterException("Unsupported browser");
        }
        eventWebDriver.register(new TestBase.MyListener());
        driver.set(eventWebDriver);
        driver.get().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }


}

