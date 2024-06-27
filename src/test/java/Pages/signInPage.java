package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class signInPage {
    private WebDriver driver;//se koristi private za da se koristi samo vo ovaa klasa
    private Select select;

    public signInPage(WebDriver driver) {
        this.driver = driver; //konstruktor
    }

    public String signInEmailValid = "mmarini1@a8.net";
    public String passwordValid = "fX5@GdKI";

    public String signInEmailInvalid = "mmarini1@a.net";
    public String passwordvalid = "fX5@GdKI";

}
