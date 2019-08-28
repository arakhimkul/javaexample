package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;
import ru.stqa.training.selenium.base.objects.LiteCartUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LiteCartCreateAccountPage {

    private WebDriver driver = DriverHolder.getDriver();

    public boolean isCaptchaDisabled() {
                return driver.findElements(By.cssSelector("input[name='captcha_id']")).size()==0;
    }

    public LiteCartCreateAccountPage submitFormWithUser(LiteCartUser userDetails) {

        return this;
    }

    public String generateRandomEmailAddress() {
        return getSaltString()+"@gmail.com";
    }


    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public LiteCartUser getRandomUser() {
        String emailAdress = generateRandomEmailAddress();
        return null;
    }
}
