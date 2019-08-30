package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.training.selenium.base.DriverHolder;
import ru.stqa.training.selenium.base.objects.LiteCartUser;

import java.util.Random;

public class LiteCartCreateAccountPage {

    private WebDriver driver = DriverHolder.getDriver();

    public boolean isCaptchaDisabled() {
        return driver.findElements(By.cssSelector("input[name='captcha_id']")).size() == 0;
    }

    public LiteCartCreateAccountPage submitCreateAccountForm() {
        driver.findElement(By.cssSelector("button[name='create_account']")).click();
        return this;
    }


    public LiteCartUser getRandomUser() {
        LiteCartUser randomUser = new LiteCartUser();
        randomUser.setEmail(generateRandomEmailAddress());
        randomUser.setFirstName(generateRandomFirstName());
        randomUser.setLastName(generateRandomLastName());
        randomUser.setAdress1(generateRandomAddress1());
        randomUser.setCity(generateRandomCity());
        randomUser.setCountry("United States");
        randomUser.setPassword("12345");
        randomUser.setPhone(generatePhoneNo());
        randomUser.setPostCode("12345");
        return randomUser;
    }

    public void fillInRequiredDetails(LiteCartUser user) {
        fillInFirstName(user.getFirstName());
        fillInLastName(user.getLastName());
        fillInAddress1(user.getAdress1());
        fillInPostCode(user.getPostCode());
        fillInCity(user.getCity());
        selectCountry(user.getCountry());
        fillInEmail(user.getEmail());
        fillInPhone(user.getPhone());
        fillInDesiredPassword(user.getPassword());
        fillInConfirmPassword(user.getPassword());
    }

    private LiteCartCreateAccountPage fillInFirstName(String firstName) {
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstName);
        return this;
    }

    private LiteCartCreateAccountPage fillInLastName(String lastName) {
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastName);
        return this;
    }

    private LiteCartCreateAccountPage fillInAddress1(String address1) {
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys(address1);
        return this;
    }

    private LiteCartCreateAccountPage fillInPostCode(String postCode) {
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys(postCode);
        return this;
    }

    private LiteCartCreateAccountPage fillInCity(String city) {
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys(city);
        return this;
    }

    private LiteCartCreateAccountPage selectCountry(String country) {
        driver.findElement(By.cssSelector("select[name='country_code']")).sendKeys(country);
        return this;
    }


    private LiteCartCreateAccountPage fillInEmail(String email) {
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        return this;
    }

    private LiteCartCreateAccountPage fillInPhone(String phone) {
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(phone);
        return this;
    }

    private LiteCartCreateAccountPage fillInDesiredPassword(String password) {
        driver.findElement(By.xpath("//td[contains(.,'Desired Password ')]/input[@name='password']")).sendKeys(password);
        return this;
    }

    private LiteCartCreateAccountPage fillInConfirmPassword(String password) {
        driver.findElement(By.xpath("//td[contains(.,'Confirm Password ')]/input[@name='confirmed_password']")).sendKeys(password);
        return this;
    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    private String generateRandomEmailAddress() {
        return getSaltString() + "@gmail.com";
    }

    private String generateRandomFirstName() {
        return "Customer " + getSaltString();
    }

    private String generateRandomLastName() {
        return "Smith " + getSaltString();
    }

    private String generateRandomAddress1() {
        return "Mulholland Drive " + getSaltString();
    }

    private String generateRandomCity() {
        return "New Settlement " + getSaltString();
    }

    private String generatePhoneNo() {
        Random rnd = new Random();
        int number = rnd.nextInt(8888) + 1000;
        return "555-" + String.valueOf(number);
    }
}
