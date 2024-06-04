package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class proceedToCheckout extends baseClass {
    @Test(dataProvider = "ProceedTOCheckOut")
    public void ProceedToCheckout(String firstname, String lastname, String company, String street, String city, String postcode, String Country, String phone) throws InterruptedException {
        magento magento = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        magento.ClickButton("//*[@class='panel wrapper']/div/ul/li[2]/a"); //to click Sign in button//
        magento.sendText("email", magento.emailAddress);//send email address//
        magento.sendText("pass", magento.password);//send password
        magento.ClickButton("//*[@id='send2']");//click on sign in button
        Thread.sleep(2000);
        magento.ClickButton("//*[@class='page-header']/div[2]/div/a");//click to cart
        Thread.sleep(2000);
        magento.ClickButton("//*[@id='top-cart-btn-checkout']");//click on proceed to Checkout//
        Thread.sleep(3000);
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='SVAM9VC']")).getText(),"Joan");

        magento.SendTextToField("//*[@name='company']", company);
        magento.SendTextToField("//*[@name='street[0]']", street);
        magento.SendTextToField("//*[@name='city']", city);
        magento.SendTextToField("//*[@name='postcode']", postcode);
        magento.SendTextToField("//*[@name='country_id']", Country);
        magento.SendTextToField("//*[@name='telephone']", phone);
        Thread.sleep(3000);
        magento.ClickButton("//*[@class='button action continue primary']"); //click proceed to checkout button
//        Thread.sleep(5000);

        WebElement placeOrderButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(., 'Place Order')]"))
        );
        Actions actions = new Actions(driver);
        actions.moveToElement(placeOrderButton).perform();
        placeOrderButton.click();

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/h1/span"))
        );

        String elementText = element.getText();
        System.out.println("The text of the element is: " + elementText);
        String actualText = element.getText();
        String expectedText = "Thank you for your purchase!";

        Assert.assertEquals(actualText, expectedText, "The text of the element does not match the expected value.");
    }
}
