package reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver browserCall() throws IOException {

      String path = System.getProperty("user.dir");
        FileInputStream fileInputStream = new FileInputStream(new File(path + "/src/main/resources/Utilities/Configuration.Properties"));
        prop = new Properties();
        prop.load(fileInputStream);
        switch (prop.getProperty("Browser").toLowerCase()){
            case "chrome" :
                System.setProperty("webDriver.chrome.driver",path +"/src/main/resources/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge"  :
               System.setProperty("webDriver,edge,driver",path +"/src/main/resources/Drivers/msedgedriver.exe");
               driver = new EdgeDriver();
            default:
                throw new IllegalArgumentException("Enter Correct Browser Name");
        }

        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;

    }
}
