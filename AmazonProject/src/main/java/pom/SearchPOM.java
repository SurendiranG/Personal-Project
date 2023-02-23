package pom;

import excelreading.readExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusable.BaseClass;

import java.time.Duration;
import java.util.List;


public class SearchPOM  {

    WebDriver driver;

  By searchText = By.xpath("//input[@type='text']");
  By searchButton = By.xpath("//input[@type='submit']");

  By selectProduct = By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");
  By addItem = By.xpath("//input[@name='submit.addToCart']");

  By goCart = By.xpath("//div[@class='a-column a-span12 sw-card-container a-span-last']//span[@class='a-button-inner']//a[@class='a-button-text']");

  By removeProduct = By.xpath("//div[@class='a-row sc-action-links']//span[@class='a-declarative']//input[@value='Delete']");


  public  SearchPOM(WebDriver driver){

    this.driver = driver;
  }

  public void searchBoxText(){
    driver.findElement(searchText).sendKeys(readExcel.ReadExcel("Product",0,0));
  }

  public void searchBoxClick(){

    driver.findElement(searchButton).click();
  }

  public void selectItem(){
    String itemName = "HP Pavilion Business Laptop";
    List<WebElement> list = driver.findElements(selectProduct);
    for (int i = 0; i < list.size(); i++){
      if (list.get(i).getText().contains(itemName)){
        list.get(i).click();
        break;

      }
    }
  }


  public void addToCart(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.presenceOfElementLocated(addItem));
    driver.findElement(addItem).click();

  }

  public void goTOCart(){
    driver.findElement(goCart).click();
  }

  public void removeItem(){
    driver.findElement(removeProduct).click();
  }

































}
