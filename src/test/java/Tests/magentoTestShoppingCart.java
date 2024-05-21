package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class magentoTestShoppingCart extends baseClass{
    @Test(dataProvider = "SignIn")
    public void ShoppingCartTest(String email, String password) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        magentoTest.Url();
        driver.manage().window().maximize();
        magentoTest.ClickButton("//*[@class='panel header']/ul/li[2]/a");//Click the SignIN button//
        magentoTest.sendText("email", email);
        magentoTest.sendText("pass", password);

        magentoTest.ClickButton("//*[@id='send2']");//Click Sign in//
        Thread.sleep(3000);
        magentoTest.ClickButton("//*[@class='navigation']/ul/li[2]/a");// Choose woman menu//
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//body/div[2]/footer/div/div/div/ul/li[1]/a")));//Scroll//
        magentoTest.ClickButton("//*[@id='maincontent']/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[3]/div/div/strong/a");//find the wanted product Selena hoodie and click//
        magentoTest.ClickButton("//*[@id='product-addtocart-button']");//click "add to cart"//
        magentoTest.ClickButton("//*[@id=\"option-label-size-143-item-166\"]");//click to choose size "xs"//
        magentoTest.ClickButton("//*[@id=\"option-label-color-93-item-56\"]");//Click to choose colour"orange://
        driver.findElement(By.xpath("//*[@id='qty']")).sendKeys(Keys.RIGHT);
        magentoTest.Backspace("qty");//using backspace I delete the previous qty //
        magentoTest.sendQty("qty",2);//choose the qty of product
        magentoTest.ClickButton("//*[@id=\"product-addtocart-button\"]");//add product to cart //

        Thread.sleep(2000);
        String productAddedToCart = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")).getText();// Validation to confirm that we
        String message = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")).getText();
        Assert.assertEquals(productAddedToCart,message); // Validation to confirm that we have added the product successfully
        Thread.sleep(2000);
        magentoTest.ClickButton("//*[@class='header content']/div/a");//click on cart //
        magentoTest.ClickButton("//*[@id='top-cart-btn-checkout']");//Click on proceed to checkout//
        String title = driver.getTitle();
        Assert.assertEquals(title,"Checkout");
        Thread.sleep(2000);

    }

}
