package com.epam.singleton.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitTool {
    public static final int DEFAULT_WAIT_4_ELEMENT = 7;
    public static final int DEFAULT_WAIT_4_PAGE = 12;


    public static WebElement waitForElementPresent(WebDriver driver, final By by) {
        WebElement element;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()

            WebDriverWait wait = new WebDriverWait(driver, 5);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
            return element; //return the element
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
