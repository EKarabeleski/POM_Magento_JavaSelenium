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

public class signIn extends baseClass {
    @Test(dataProvider = "SignIn")// ovoj za sign in test
        public void SignIn(String email, String password) throws InterruptedException{
          magento magentoSignin = new magento(driver);
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          magentoSignin.ClickButton("//*[@class='panel wrapper']/div/ul/li[2]/a");//Click Sgn in button
//         driver.findElement(By.xpath("//*[@class='panel wrapper']/div/ul/li[2]/a")).click();
          magentoSignin.sendText("email", email);//data provider set
          magentoSignin.sendText("pass", password);
          magentoSignin.ClickButton("//*[@id='send2']");//Click Sign in//
          Thread.sleep(3000);
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='panel header']")).getText(),"Welcome, Zachary Trynor! ");
        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel header']")));
        WebElement actualMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel header']")));
        String ActualMessage = actualMessage.getText();
        String ResponseMessage= responseMessage.getText();
        Assert.assertEquals(ActualMessage,ResponseMessage);// Validation of successfully logged in

      }
}
