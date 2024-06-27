package Tests;

import Pages.checkout;
import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class proceedToCheckout extends baseClass {

        @Test(dataProvider = "RandomGeneratedFaker3")
        public void checkout (String email, String password) throws InterruptedException {
            magento magentoSignin = new magento(driver);
            checkout checkout = new checkout(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            Actions actions = new Actions(driver);

            magentoSignin.ClickButton("//*[@class='panel wrapper']/div/ul/li[2]/a"); // Click Sign in button

            magentoSignin.sendText("email", email); // Enter email
            magentoSignin.sendText("pass", password); // Enter password
            magentoSignin.ClickButton("//*[@id='send2']"); // Click Sign in button

            WebElement successElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")));// validation of successfull sign in
            Assert.assertTrue(successElement.isDisplayed(), "Successful sign-in or registration message not displayed");
            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/header/div[1]/div/ul/li[1]/span")));

            checkout.clickButton("//*[@class=\"navigation\"]/ul/li[4]/a");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"ui-id-25\"]"))).click();
            checkout.clickButton("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"))).click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img")));//Scroll to element
            checkout.clickButton("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img");
            checkout.clickButton("//*[@class=\"action primary tocart\"]");

            Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"page-title\"]")).getText(), "Push It Messenger Bag");// Product name validation
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"product-price-14\"]")).getText(), "$45.00");// Price validation
            Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"stock available\"]")).getText(),"IN STOCK"); //Validation that product is with in stock status availability

            checkout.clickButton("//*[@class='page-header']/div[2]/div/a");// click to cart

            WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top-cart-btn-checkout']")));
            checkout.clickButton("//*[@id='top-cart-btn-checkout']");//Click on proceed to checkout//

            checkout.SendText("//*[@name='company']", checkout.company);
            checkout.SendText("//*[@name='street[0]']", checkout.street);
            checkout.SendText("//*[@name='city']", checkout.city);
            checkout.SendText("//*[@name='postcode']", checkout.postcode);
            checkout.FromDropDown("//*[@name='region_id']", checkout.regionValue);
            checkout.FromDropDown("//*[@name='country_id']", checkout.countryValue);
            checkout.SendText("//*[@name='telephone']", checkout.phone);
            checkout.clickButton("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input");// choose Best way to shipping method
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"label_carrier_bestway_tablerate\"]")).getText(),"Best Way");//validation for Shipping method
//        checkout.clickButton("//*[@class='button action continue primary']");// click next
            checkout.clickButton("//*[@id=\"shipping-method-buttons-container\"]/div/button");//click next
            WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'action primary checkout')]")));//
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);// Click place order

            String expectedText = "Thank you for your purchase!";
            WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/h1/span")));
            String actualText = confirmationMessage.getText();
            System.out.println("Confirmation message: " + confirmationMessage);
            Assert.assertEquals(actualText, expectedText, "The text of the element does not match the expected value.");

    }


}
