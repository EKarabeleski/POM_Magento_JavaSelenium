package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class magento {

//    By xpath "//*[@class='panel wrapper']/div/ul/li[3]/a";

    private WebDriver driver;

    public magento(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(String className) {
        driver.findElement(By.className(className)).click();
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
}

