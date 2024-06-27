package Tests;

import Pages.magento;
import Pages.signInPage;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class signIn extends baseClass {


    @Test(dataProvider = "RandomGeneratedFaker2")
    public void SignInFromTxt(String email, String password) throws InterruptedException {
        magento magentoSignin = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        magentoSignin.ClickButton("//*[@class='panel wrapper']/div/ul/li[2]/a"); // Click Sign in button

        magentoSignin.sendText("email", email); // Enter email
        magentoSignin.sendText("pass", password); // Enter password
        magentoSignin.ClickButton("//*[@id='send2']"); // Click Sign in button

        WebElement successElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")));// validation of successfull sign in
        Assert.assertTrue(successElement.isDisplayed(), "Successful sign-in or registration message not displayed");

    }
      @Test
    public void SignInInvlaidEmail () throws InterruptedException{

          magento magentoSignin = new magento(driver);
          signInPage signInPage =new signInPage(driver);

          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          signIn.driver.findElement(By.xpath("//*[@class='panel wrapper']/div/ul/li[2]/a")).click();//Click Sgn in button
          magentoSignin.sendText("email", signInPage.signInEmailInvalid);//data provider set
          magentoSignin.sendText("pass", signInPage.passwordvalid);
          magentoSignin.ClickButton("//*[@id='send2']");//Click Sign in//

          WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
//          WebElement actualMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel header']")));
          String ActualMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
          String ResponseMessage= responseMessage.getText();
          Assert.assertEquals(ActualMessage,ResponseMessage);// Validation of successfully logged in

      }
      @Test
    public void SignInEmptyField () throws InterruptedException{
          magento magentoSignin = new magento(driver);
          signInPage signInPage =new signInPage(driver);

          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          signIn.driver.findElement(By.xpath("//*[@class='panel wrapper']/div/ul/li[2]/a")).click();//Click Sgn in button
          magentoSignin.sendText("email", signInPage.signInEmailValid);//login with valid email

          magentoSignin.ClickButton("//*[@id='send2']");//Click Sign in//

          WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pass-error']")));

          String ActualMessage = "This is a required field.";
          String ResponseMessage= responseMessage.getText();
          Assert.assertEquals(ActualMessage,ResponseMessage);// Validation of required field in sign in.
      }
}
