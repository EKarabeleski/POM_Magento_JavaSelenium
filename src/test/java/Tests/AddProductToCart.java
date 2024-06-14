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

public class AddProductToCart extends baseClass {
    @Test(dataProvider = "SignIn")
    public void addProducts(String email, String password) throws InterruptedException {
        magento magentoTest = new magento(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        magentoTest.ClickButton("//body/div[2]/header/div[1]/div/ul/li[2]/a");//Click on sign IN button
        magentoTest.sendText("email", email); //send email address form data provider
        magentoTest.sendText("pass", password);

        magentoTest.ClickButton("//body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button");//Click Sign in//
//        Thread.sleep(3000);
        magentoTest.ClickButton("//*[@class='navigation']/ul/li[2]/a");// Choose woman menu//

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//body/div[2]/footer/div/div/div/ul/li[1]/a")));//Scroll//

        magentoTest.ClickButton("//*[@id='maincontent']/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[3]/div/div/strong/a");//find the wanted product Selena hoodie and click//
        magentoTest.ClickButton("//*[@id='product-addtocart-button']");//click "add to cart"//
        magentoTest.ClickButton("//*[@id=\"option-label-size-143-item-166\"]");//click to choose size "xs"//
        magentoTest.ClickButton("//*[@id=\"option-label-color-93-item-56\"]");//Click to choose colour"orange://
        driver.findElement(By.xpath("//*[@id='qty']")).sendKeys(Keys.RIGHT);
        magentoTest.Backspace("qty");//using backspace I delete the previous qty //
        magentoTest.sendQty("qty", 2);//choose the qty of product
        magentoTest.ClickButton("//*[@id=\"product-addtocart-button\"]");//add product to cart //

        magentoTest.ClickButton("//*[@class='header content']/div/a");//click on cart //
        magentoTest.ClickButton("//*[@id='top-cart-btn-checkout']");//Click on proceed to checkout//
        String title = driver.getTitle();
        Assert.assertEquals(title, "Checkout");
        Thread.sleep(2000);

        }
    }


//        private String randomString() {
//            String email;
//            RandomString randomString = new RandomString(10);
//            email =  randomString.nextString() + "@test.com";
//            return email;
//        }
//        Thread.sleep(2000);
//        String productAddedToCart = driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div")).getText();// Validation to confirm that we
//        String message = driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div")).getText();
//        Assert.assertEquals(productAddedToCart, message); // Validation to confirm that we have added the product successfully
//        Thread.sleep(2000);
////        List<WebElement> dataList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.shipping-address-item.selected-item")));
//        List<WebElement> dataList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.shipping-address-item.selected-item")));
//
//        for (WebElement element : dataList) {
//            // Example assertion: Check if each element's text contains expected data
//            String elementText = element.getText();
//            // You can add your assertion logic here
//            // For example:
//             Assert.assertTrue(elementText.contains("expectedData"));