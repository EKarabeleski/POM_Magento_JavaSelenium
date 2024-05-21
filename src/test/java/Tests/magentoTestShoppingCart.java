package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class magentoTestShoppingCart extends baseClass{
    @Test(dataProvider = "AccountRegistration")//ovoj test raboti//
    public void ShoppingCartTest(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
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
        magentoTest.ClickButton("//*[@class='navigation']/ul/li[2]/a");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//body/div[2]/footer/div/div/div/ul/li[1]/a")));
        magentoTest.ClickButton("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[3]/div/div/strong/a");



        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(magentoTest.responseMessage));
        Assert.assertEquals(responseMessage.getText(), "Thank you for registering with Main Website Store.");

    }

}
