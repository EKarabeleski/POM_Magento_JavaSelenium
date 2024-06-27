package Tests;

import Pages.checkout;
import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2ETest extends baseClass {

    @Test(dataProvider = "RandomGeneratedFaker")
    public void createNewAccount(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {

        magento magentoTest = new magento(driver);
        checkout checkout = new checkout(driver);
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
        magentoTest.ClickButton("//*[@class='navigation']/ul/li[2]/a");// Choose woman menu//
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"page-title\"]")).getText(),"Women");//Validation that we are in women section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//body/div[2]/footer/div/div/div/ul/li[1]/a")));//Scroll//

        magentoTest.ClickButton("//*[@id='maincontent']/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[3]/div/div/strong/a");//find the wanted product Selena hoodie and click//
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"page-title\"]")).getText(), "Selene Yoga Hoodie");// Product name validation
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"product-price-1108\"]")).getText(), "$42.00");// Price validation
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"stock available\"]")).getText(),"IN STOCK"); //Validation that product is with in stock status
        magentoTest.ClickButton("//*[@id='product-addtocart-button']");//click "add to cart"//
        magentoTest.ClickButton("//*[@id=\"option-label-size-143-item-166\"]");//click to choose size "xs"//
        magentoTest.ClickButton("//*[@id=\"option-label-color-93-item-56\"]");//Click to choose colour"orange://
        driver.findElement(By.xpath("//*[@id='qty']")).sendKeys(Keys.RIGHT);
        magentoTest.Backspace("qty");//using backspace I delete the previous qty //
        magentoTest.sendQty("qty", 2);//choose the qty of product
        magentoTest.ClickButton("//*[@id=\"product-addtocart-button\"]");//add to cart //
        Thread.sleep(3000);

        magentoTest.ClickButton("//*[@class='header content']/div/a");//click on cart //
        magentoTest.ClickButton("//*[@id='top-cart-btn-checkout']");//Click on proceed to checkout//
        String title = driver.getTitle();
        Assert.assertEquals(title, "Checkout");
        Thread.sleep(2000);
        magentoTest.ClickButton("//*[@class=\"logo\"]");
        magentoTest.ClickButton("//*[@class='navigation']/ul/li[6]/a");// Choose sale menu//
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"page-title-heading\"]")).getText(),"Sale");//Validation that we are in sale section

        magentoTest.ClickButton("//*[@class=\"categories-menu\"]/ul[1]/li[2]/a");// click on womens deal/ Jacket section\
        magentoTest.ClickButton("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"page-title\"]")).getText(), "Olivia 1/4 Zip Light Jacket");// Product name validation
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"product-info-main\"]/div[3]/div/span")).getText(), "As low as\n" +
                "$77.00");// Price validation
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"stock available\"]")).getText(),"IN STOCK"); //Validation that product is with in stock status
        magentoTest.ClickButton("//*[@id=\"option-label-size-143-item-166\"]");//click to choose size "xs"//
        magentoTest.ClickButton("//*[@id=\"option-label-color-93-item-57\"]");//Click to choose colour"pink://
        checkout.clickButton("//*[@class='page-header']/div[2]/div/a");// click to cart
        Thread.sleep(3000);
        magentoTest.ClickButton("//*[@id='top-cart-btn-checkout']");//Click on proceed to checkout//

        checkout.SendText("//*[@name='company']", checkout.company);
        checkout.SendText("//*[@name='street[0]']", checkout.street);
        checkout.SendText("//*[@name='city']", checkout.city);
        checkout.SendText("//*[@name='postcode']", checkout.postcode);
        checkout.FromDropDown("//*[@name='region_id']", checkout.regionValue);
        checkout.FromDropDown("//*[@name='country_id']", checkout.countryValue);
        checkout.SendText("//*[@name='telephone']", checkout.phone);
        magentoTest.ClickButton("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input");// choose Best way to shipping method
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"label_carrier_bestway_tablerate\"]")).getText(),"Best Way");//validation for Shipping method
//        checkout.clickButton("//*[@class='button action continue primary']");// click next
        magentoTest.ClickButton("//*[@id=\"shipping-method-buttons-container\"]/div/button");//click next
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
