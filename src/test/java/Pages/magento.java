package Pages;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class magento {


    private WebDriver driver;//se koristi private za da se koristi samo vo ovaa klasa
    private Select select;

    public magento(WebDriver driver) {
        this.driver = driver; //konstruktor
    }

    public void ClickButton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void Url() throws InterruptedException {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);
    }

    public void clickRegister(String xpath) {
        driver.findElement(By.xpath(xpath)).click();

    }

    public void sendText(String id, String text) throws InterruptedException {
        driver.findElement(By.id(id)).sendKeys(text);
        Thread.sleep(2000);
    }


    public void SendTextToField(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public By responseMessage = By.xpath("//*[@class='message-success success message']");//this is message for successful registration//

    public String getResponseMessage(String xpath) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).getText();
        return getResponseMessage(xpath);
    }

    public void sendQty(String id, int number) throws InterruptedException {
        driver.findElement(By.id(id)).sendKeys(String.valueOf(number));
        Thread.sleep(2000);
    }

    public void Backspace(String id) throws InterruptedException {
        WebElement field = driver.findElement(By.id(id));
        String value = field.getAttribute("value");
        for (int i = 0; i < value.length(); i++) {
            field.sendKeys(Keys.BACK_SPACE);
        }
    }

    public String emailAddress = "kraig.swaniawski@yahoo.com"; //hoyt.hintz@gmail.com
    public String password = "@4qv9AkES*OR";//K&cW52!81

    public String randomString() {
        String email;
        RandomString randomString = new RandomString(10);
        email = randomString.nextString() + "@test.com";
        return email;
    }

    public void SelectFromDropDown(String xpath, String value) {
        select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByValue(value);
    }

    public By addToCartButton = By.xpath("//*[@id=\"product-addtocart-button\"]");

    private boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return false; // Element found, so product is not deleted
        } catch (NoSuchElementException e) {
            return true; // Element not found, so product is deleted
        }
    }
}

