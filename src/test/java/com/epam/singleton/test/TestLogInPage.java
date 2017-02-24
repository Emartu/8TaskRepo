package com.epam.singleton.test;


import com.epam.singleton.base.Driver;
import com.epam.singleton.business_objects.User;
import com.epam.singleton.steps.TestLoginSteps;
import com.epam.singleton.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestLogInPage {

    private TestLoginSteps objTestloginSteps;
    private String login = "testtask28";
    private String password = "testtask28testtask28";


    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Driver.quit();
    }

    @DataProvider(name = "Login_Provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {new User(login, password)}
        };
    }

    @Test(dataProvider = "Login_Provider", groups = "Login Page Test", description = "Tests whether user is Logged In", testName = "testLogin")
    public void testLogin(User user) {
        objTestloginSteps = new TestLoginSteps();
        objTestloginSteps.openMailWebAddress(TestInput.mailBoxUrl);
        objTestloginSteps.doLogin(user);
        Assert.assertTrue(objTestloginSteps.isLoginSuccessful(), "Element is not found, seems like User is not logged in ... ");
    }

}



