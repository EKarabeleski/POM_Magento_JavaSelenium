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
        WebElement cart = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//body/div[2]/header/div[2]/div[1]/a"))
        );
        magento.ClickButton("//*[@class='page-header']/div[2]/div/a");//click to cart
        Thread.sleep(2000);
        magento.ClickButton("//*[@id='top-cart-btn-checkout']");//click on proceed to Checkout//
        Thread.sleep(3000);

        magento.ClickButton("//*[@class='action action-show-popup']");
        magento.SendTextToField("//*[@name='company']", company);
        magento.SendTextToField("//*[@name='street[0]']", street);
        magento.SendTextToField("//*[@name='city']", city);
        magento.SendTextToField("//*[@name='postcode']", postcode);
        magento.SendTextToField("//*[@name='country_id']", Country);
        magento.SendTextToField("//*[@name='telephone']", phone);
        Thread.sleep(3000);
//
        magento.ClickButton("//*[@class=\"action primary action-save-address\"]");//click ship here
        magento.ClickButton("//*[@class='button action continue primary']"); //click next proceed to checkout button
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'action primary checkout')]//span[text()='Place Order']")));//
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);

        String expectedText = "Thank you for your purchase!";
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/h1/span")));
        String actualText = confirmationMessage.getText();
                System.out.println("Confirmation message: " + confirmationMessage);
        Assert.assertEquals(actualText, expectedText, "The text of the element does not match the expected value.");
    }
}
