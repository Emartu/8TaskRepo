package com.epam.factory_method.base;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
    protected static WebDriver driver;

    public abstract WebDriver FactoryMethod();

}
