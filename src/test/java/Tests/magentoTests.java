package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class magentoTests extends baseClass {
    @Test(dataProvider = "RegisterDataProvider")// ovoj test ne rabot na ignore  e da go proveram//
    public void registerAccount(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        magentoTest.Url();
        driver.manage().window().maximize();
        magentoTest.clickRegister("//*[@class='panel wrapper']/div/ul/li[3]/a");
        magentoTest.sendText("firstname", firstname);
        magentoTest.sendText("lastname", lastname);
        magentoTest.sendText("email_address", email);
        magentoTest.sendText("password", password);
        magentoTest.sendText("password-confirmation", confirmPassword);
        magentoTest.clickRegister("//*[@class='action submit primary']");
        Thread.sleep(3000);
        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(magentoTest.responseMessage));
        Assert.assertEquals(responseMessage.getText(), "Thank you for registering with Main Website Store.");
    }

    @Test(dataProvider = "DataProviderAccountRegistration")//ovoj test raboti//
    public void registerAccount1(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        magentoTest.Url();
        driver.manage().window().maximize();
        magentoTest.clickRegister("//*[@class='panel wrapper']/div/ul/li[3]/a");
        magentoTest.sendText("firstname", firstname);
        magentoTest.sendText("lastname", lastname);
        magentoTest.sendText("email_address", email);
        magentoTest.sendText("password", password);
        magentoTest.sendText("password-confirmation", confirmPassword);
        magentoTest.clickRegister("//*[@class='action submit primary']");
        Thread.sleep(3000);

        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(magentoTest.responseMessage));
        Assert.assertEquals(responseMessage.getText(), "Thank you for registering with Main Website Store.");
    }

        @Test(dataProvider = "RandomGeneratedFaker")//ovoj test raboti//
    public void registerAccount2(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        magentoTest.Url();
        driver.manage().window().maximize();
        magentoTest.clickRegister("//*[@class='panel wrapper']/div/ul/li[3]/a");
        magentoTest.sendText("firstname", firstname);
        magentoTest.sendText("lastname", lastname);
        magentoTest.sendText("email_address", email);
        magentoTest.sendText("password", password);
        magentoTest.sendText("password-confirmation", confirmPassword);
        magentoTest.clickRegister("//*[@class='action submit primary']");
        Thread.sleep(3000);
        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(magentoTest.responseMessage));
            Assert.assertEquals(responseMessage.getText(), "Thank you for registering with Main Website Store.");

    }
}

