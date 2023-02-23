package com.lm.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import reusable.BaseClass;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    @Before
    public void preCondition() {
        String path = System.getProperty("user.dir") + "/src/test/resources/log4j.Properties";
        PropertyConfigurator.configure(path);
    }

    @AfterStep
    public void captureScreenShot(Scenario Sc) {
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Sc.attach(screenShot, "image/png", null);
    }
}
