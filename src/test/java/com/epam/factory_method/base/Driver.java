package com.epam.factory_method.base;


import org.openqa.selenium.WebDriver;

public class Driver {

    public static WebDriver Instance = null;

    private Driver() {
    }

    public static WebDriver initBrowser(String browser) {
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverCreator creator = new ChromeDriverCreator();
                Instance = creator.FactoryMethod();
                return Instance;
            case "FIREFOX":
                WebDriverCreator creator1 = new FirefoxDriverCreator();
                Instance = creator1.FactoryMethod();
                return Instance;
            default:
                System.out.println("Enter preferred browser type: Firefox or Chrome");
        }
        return null;
    }

    public static void goToUrl(String url) {
        Instance.get(url);
    }

    public static void quitBrowser() {
        Instance.quit();
    }

}

