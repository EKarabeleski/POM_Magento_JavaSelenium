package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class magento {



    private WebDriver driver;

    public magento(WebDriver driver) {
        this.driver = driver;
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
//    //*[@class='navigation']/ul/li[2]/a this is xpath for woman tab menu
//    "//body/div[2]/footer/div/div/div/ul/li[1]/a" xpath for scroll element
//JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath(xpath)));
}
