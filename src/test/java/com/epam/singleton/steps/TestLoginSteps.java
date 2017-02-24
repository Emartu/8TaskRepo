package com.epam.singleton.steps;


import com.epam.singleton.base.Driver;
import com.epam.singleton.business_objects.User;
import com.epam.singleton.pages.LogInPage;



public class TestLoginSteps {

    LogInPage logInPage = new LogInPage(Driver.Initialize());

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



