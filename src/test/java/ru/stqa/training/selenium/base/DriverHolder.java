package ru.stqa.training.selenium.base;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverHolder {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal();


    public DriverHolder() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver receivedDriver) {
        driver.set(receivedDriver);
    }

}
