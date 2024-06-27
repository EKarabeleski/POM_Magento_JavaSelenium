package Tests;

import Pages.magento;
import Pages.register;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class magentoSignupTests extends baseClass {


    @Test(dataProvider = "RandomGeneratedFaker")
    public void CreateAccount(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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


    @Test
    public void registerWithInvalidEmail() throws InterruptedException{
        register register = new register (driver);
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        magentoTest.clickRegister("//*[@class='panel wrapper']/div/ul/li[3]/a");
        magentoTest.sendText("firstname", register.firstNameInvalid);
        magentoTest.sendText("lastname", register.lastnameInvalid);
        magentoTest.sendText("email_address",register.signInEmailInvalid);//  validation of invalid message

        magentoTest.sendText("password", register.passwordInvalid);
        magentoTest.sendText("password-confirmation", register.passwordInvalid);
        magentoTest.clickRegister("//*[@class='action submit primary']");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='maincontent']/div[2]")).isDisplayed(), "Success message displayed?");

        magentoTest.clickRegister("//*[@class='panel wrapper']/div/ul/li[3]/a");
        magentoTest.sendText("firstname", register.firstName);
        magentoTest.sendText("lastname", register.lastname);
        magentoTest.sendText("email_address",register.signInEmail);

        magentoTest.sendText("password", register.password);
        magentoTest.sendText("password-confirmation", register.password);
        magentoTest.clickRegister("//*[@class='action submit primary']");

        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(magentoTest.responseMessage));
        Assert.assertEquals(responseMessage.getText(), "Thank you for registering with Main Website Store.");// Validation of successfully registered account
    }
}

