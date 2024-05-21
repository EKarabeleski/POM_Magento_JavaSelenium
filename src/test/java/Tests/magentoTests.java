package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class magentoTests extends baseClass {
    @Test(dataProvider = "RegisterDataProvider")
    public void createAnAccount(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
        magento magentoTest = new magento(driver);
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
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='message-success success message']")).getText(), "Thank you for registering with Main Website Store.");
    }

    @Test(dataProvider = "5ArrayDataProvider")
    public void createAnAccount1(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
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

        String actualMessage = magentoTest.getResponseMessage("//*[@class='message-success success message']");
        String expectedMessage = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage + " but got: " + actualMessage);
    }

        @Test(dataProvider = "RandomGeneratedFaker")
    public void registerData(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
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
        String actualMessage = responseMessage.getText();
        Assert.assertTrue(actualMessage.contains((CharSequence) responseMessage),
                "Expected message: " + responseMessage + " but got: " + actualMessage);


    }
}

