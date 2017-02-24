package com.epam.singleton.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver Instance = null;

    private Driver() {
    }

    public static WebDriver Initialize() {
        System.setProperty("webdriver.chrome.driver", "resource\\chromedriver_win32(1)\\chromedriver.exe");
        if (Instance == null) {
            Instance = new ChromeDriver();
        }
        return Instance;
    }

    public static void goToUrl(String url) {
        Driver.Instance.get(url);
    }

    public static void quit() {
        System.out.println("Quit Browser");
        Instance.quit();
    }

}
