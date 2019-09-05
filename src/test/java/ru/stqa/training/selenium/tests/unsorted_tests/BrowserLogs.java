package ru.stqa.training.selenium.tests.unsorted_tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.TestBase;

import java.util.List;

public class BrowserLogs extends TestBase {

    @Test
    public void browserLogs() {
        DriverHolder.getDriver().get("https://wiley.ru");
        LogEntries logPointer = DriverHolder.getDriver().manage().logs().get("browser");
        List<LogEntry> logs = logPointer.getAll();
        Assert.assertTrue(logs.size() == 0);
        System.out.println(logs);

    }
}
