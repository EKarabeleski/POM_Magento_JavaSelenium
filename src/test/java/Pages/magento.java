package Pages;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class magento {


    private WebDriver driver;//se koristi private za da se koristi samo vo ovaa klasa

    public magento(WebDriver driver) {
        this.driver = driver; //konstruktor
    }

    public void clickButton(String id) {
        driver.findElement(By.id(id)).click();
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

    public void SendPass(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
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

    public void getTextValue(String id) throws InterruptedException {
        driver.findElement(By.id(id)).getText();
    }

    public By signInEmail = By.id("email");
    public By clickToCart = By.xpath("//*[@class='page-header']/div[2]/div/a");//xpath za cart kopce
    public By signIn = By.xpath("//*[@class='panel wrapper']/div/ul/li[2]/a");//xpath za sign in kopce
    public By proceedTOCheckOutButton = By.id("top-cart-btn-checkout");
    public String emailAddress = "kraig.swaniawski@yahoo.com";
    public String password = "@4qv9AkES*OR";

    public String randomString() {
            String email;
            RandomString randomString = new RandomString(10);
            email =  randomString.nextString() + "@test.com";
            return email;
        }
}