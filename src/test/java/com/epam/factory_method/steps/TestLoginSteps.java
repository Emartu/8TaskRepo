package com.epam.factory_method.steps;


import com.epam.factory_method.base.ChromeDriverCreator;
import com.epam.factory_method.base.Driver;
import com.epam.factory_method.base.WebDriverCreator;
import com.epam.factory_method.business_objects.User;
import com.epam.factory_method.pages.LogInPage;
import org.openqa.selenium.WebDriver;


public class TestLoginSteps {

    LogInPage logInPage = new LogInPage(Driver.Instance);

    public void openMailWebAddress(String url) {
        Driver.goToUrl(url);
    }

    public void doLogin(User user) {
        logInPage.doLogin(user.getLogin(), user.getPassword());
    }

    public boolean isLoginSuccessful() {
        return logInPage.userPresented();
    }

}



