package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class register {
    private WebDriver driver;//se koristi private za da se koristi samo vo ovaa klasa
    private Select select;

    public register(WebDriver driver) {
        this.driver = driver; //konstruktor
    }

    public String signInEmailInvalid = "mmarini1@a8.net";
    public String passwordInvalid = "fX5@GdKI";
    public String firstNameInvalid = "Micah";
    public String lastnameInvalid = "Marini";
    public String signInEmail = "sthaller0@jiathis.com";
    public String password = "fX5!GdKI";
    public String firstName = "Scotty";
    public String lastname = "Thaller";
    public Object[][] readDataFromFile(String filePath) throws IOException {
        // Read data from the file
        List<String> lines = Files.readAllLines(Paths.get(filePath));

    Object[][] registerData = new Object[lines.size()][5];
    for (int i = 0; i < lines.size(); i++) {
        String[] data = lines.get(i).split(", ");
        for (int j = 0; j < 5; j++) {
            registerData[i][j] = data[j];
        }
    }

    return registerData;
}
}


