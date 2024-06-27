package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class checkout {
    private WebDriver driver;//se koristi private za da se koristi samo vo ovaa klasa
    private Select select;

    public checkout(WebDriver driver) {
        this.driver = driver; //konstruktor
    }
    public void clickButton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
        public void sendEmail(String id, String Email) {
            driver.findElement(By.id(id)).sendKeys(Email);
        }
    public void sendPass(String id, String pass) {
        driver.findElement(By.id(id)).sendKeys(pass);
    }
        public String Email = "pwemm3@imgur.com";
        public String pass ="123qwe!123";
        public By cart = By.xpath("//*[@class='page-header']/div[2]/div/a");
    public String company = "AB";
    public String street = "Street1";
    public String city = "Ilinois";
    public String postcode = "61259";
    public  String regionValue="23";
    public  String countryValue="US";
    public String phone = "00712568";
    public void SendText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }
    public void FromDropDown(String xpath, String value) {
        select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByValue(value);
    }

}
