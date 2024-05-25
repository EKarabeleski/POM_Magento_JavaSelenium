package Utils;

import net.datafaker.Faker;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dataProviders {
    @DataProvider(name = "DataProviderAccountRegistration")
    public Object[][] test3Data() {
        return new Object[][]{
                {"Marena", "Izkovitz", "ksolanj@wikimedia.org", "eY3/|Z<'p'9n", "eY3/|Z<'p'9n"},
                {"Zachary", "Trynor", "ztrynoro@angelfire.com", "wM3$P3/#?Y2M*D(Y", "wM3$P3/#?Y2M*D(Y"},
                {"Filippo", "Piff", "fpifft@newsvine.com", "fS9/VF'F7ZBtN", "fS9/VF'F7ZBtN"},
        };
    }

    @DataProvider(name = "RegisterDataProvider")
    public Object[][] readFromFile() throws IOException { //za citanje na fileovi//
        Object[][] registerData;
        File textFile = new File("D:\\Projects\\final project import csv\\Register_Data_DP.txt");

        List<String> list = new ArrayList<String>();
        int dataRows, i = 0;
        list = Files.readAllLines(textFile.toPath(), Charset.defaultCharset());
        dataRows = list.size();
        registerData = new Object[dataRows][5];
        for (String line : list) {
            String[] res = line.split(",");
            registerData[i][0] = res[0];
            registerData[i][1] = res[1];
            registerData[i][2] = res[2];
            registerData[i][3] = res[3];
            registerData[i][4] = res[4];
            i++;
        }
        return registerData;
    }

    @DataProvider(name = "RandomGeneratedFaker")
    public Object[][] test4Data() throws IOException {
        Object[][] registerData;
        registerData = new Object[3][5];
        Faker faker = new Faker();
        int i;
        FileWriter fileWriter = new FileWriter("generatedData.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);


        for (i = 0; i < 3; i++) {
            String password = faker.internet().password(8, 12, true, true, true);
            registerData[i][0] = faker.name().firstName();
            registerData[i][1] = faker.name().lastName();
            registerData[i][2] = faker.internet().emailAddress();
            registerData[i][3] = password;
            registerData[i][4] = password;
            // Save to file
            printWriter.println(Arrays.deepToString(registerData));
        }
        printWriter.close();
        fileWriter.close();
        return registerData;
    }
    @DataProvider(name = "SignIn")// Using to sign in with valid email and password
    public Object[][] testCart() {
        return new Object[][]{
                {"ztrynoro@angelfire.com", "wM3$P3/#?Y2M*D(Y"},
        };
    }
    @DataProvider(name = "SignInto")// Using to sign in with valid email and password
    public Object[][] testSignIn() {
        return new Object[][]{
                {"ztrynoro@angelfire.com", "wM3$P3/#?Y2M*D(Y"},
        };
    }
}
