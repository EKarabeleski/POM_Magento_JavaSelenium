package Tests;

import Pages.magento;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductToCart extends baseClass {
    @Test(dataProvider = "SignIn")
    public void addProducts(String email, String password) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        magentoTest.ClickButton("//body/div[2]/header/div[1]/div/ul/li[2]/a");//Click on sign IN button
        magentoTest.sendText("email", email); //send email address form data provider
        magentoTest.sendText("pass", password);

        magentoTest.ClickButton("//body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button");//Click Sign in//
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/header/div[1]/div/ul/li[1]/span")));
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//body/div[2]/header/div[1]/div/ul/li[1]/span")).getText(),
                "Welcome, Pammie Wemm!"); //validation for successfull sing in
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
        magentoTest.ClickButton("//*[@id=\"product-addtocart-button\"]");//add to cart //

    }
}

