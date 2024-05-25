package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class signIn extends baseClass {
    @Test()
        public void SignIn() throws InterruptedException{
          magento magentoSignin = new magento(driver);
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ2luLw%2C%2C/");
          driver.manage().window().maximize();
          magento.sendText("email",);
        magento.sendText("pass",);
//          magento.sendText("email", email);
//          magento.sendText("pass", Password);

          magento.ClickButton("//*[@id='send2']");//Click Sign in//
          Thread.sleep(3000);
      }
}
