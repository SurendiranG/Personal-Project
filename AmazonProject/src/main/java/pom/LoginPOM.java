package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusable.BaseClass;

public class LoginPOM extends BaseClass {
    public static WebDriver driver;

    By username = By.name("email");
    By password = By.name("password");
    By click = By.id("continue");
    By signin = By.id("signInSubmit");


    public LoginPOM (WebDriver driver){
        this.driver = driver;
    }

   public void enterUsername(){
        driver.findElement(username).sendKeys(prop.getProperty("Username"));
   }
   public void enterPassword(){
        driver.findElement(password).sendKeys(prop.getProperty("Password"));
   }
   public void enterClick(){
        driver.findElement(click).click();
   }
   public void enterSignin(){
        driver.findElement(signin).click();
   }

}
