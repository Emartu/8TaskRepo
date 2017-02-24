package com.epam.factory_method.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverCreator extends WebDriverCreator {


    @Override
    public WebDriver FactoryMethod() {
        System.setProperty("webdriver.gecko.driver", "resource\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        FirefoxBinary binary = new FirefoxBinary(new File("c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        FirefoxProfile profile = new FirefoxProfile(new File(
                "c:\\FFProfile\\"));
        driver = new FirefoxDriver(binary, profile);
        return driver;
    }

}
