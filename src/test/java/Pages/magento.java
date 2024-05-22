package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class magento {


    private WebDriver driver;//se koristi private za da se koristi samo vo ovaa klasa

    public magento(WebDriver driver) {
        this.driver = driver; //konstruktor
    }

    public void clickButton(String className) {
        driver.findElement(By.className(className)).click();
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
}
