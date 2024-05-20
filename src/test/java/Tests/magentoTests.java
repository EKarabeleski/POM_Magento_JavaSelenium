package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//git test
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
    }

    @Test(dataProvider = "RandomGeneratedFaker")
    public void registerData(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
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
    }
}

