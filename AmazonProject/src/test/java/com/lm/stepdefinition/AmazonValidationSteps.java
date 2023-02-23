package com.lm.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.LoginPOM;
import pom.SearchPOM;
import reusable.BaseClass;

import java.io.IOException;

public class AmazonValidationSteps extends BaseClass {
    public WebDriver driver;
    public LoginPOM login;
    public SearchPOM search;
    @Given("User navigates to the given Amazon login page")
    public void loginPage() throws IOException {
     driver =   BaseClass.browserCall();
    }
    @When("User enters the valid credentials and navigate to Homepage")
    public void navigateTOHomePage() {
        login = new LoginPOM(driver);
        login.enterUsername();
        login.enterClick();
        login.enterPassword();
        login.enterSignin();
    }

    @And("User clicks the signout button")
    public void clicksSignOut(){
       WebElement accountSignOut =  driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions signOutHover = new Actions(driver);
        signOutHover.clickAndHold(accountSignOut).build().perform();
        driver.findElement(By.linkText("Sign Out")).click();
    }

    @Then("User should verify that signout successfully")
    public void verifySuccessfully(){
       String title = driver.getTitle();
        Assert.assertEquals(title,"Amazon Sign in");
    }


    @Given("User navigates to the Homepage")
    public void navigatesHomepage() throws IOException {
       driver = BaseClass.browserCall();
    }

    @When("User select the item and add to the cart")
    public void selectAddToCart(){
       search = new SearchPOM(driver);
       search.searchBoxText();
       search.searchBoxClick();
       search.selectItem();
    }

    @And("User verify the item added successfully")
    public void addSuccessfully(){
        search.addToCart();
        search.goTOCart();
    }

    @When("User removes the item added on the cart")
    public void removeItem(){
       search.removeItem();
    }

    @Then("User should verify that the item is removed successfully")
    public void itemRemovedSuccessfully(){

    }
}
