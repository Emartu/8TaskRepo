package com.epam.factory_method.test;


import com.epam.factory_method.base.Driver;
import com.epam.factory_method.business_objects.User;
import com.epam.factory_method.steps.TestLoginSteps;
import com.epam.factory_method.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestLogInPage {

    private TestLoginSteps objTestloginSteps;
    private String login = "testtask28";
    private String password = "testtask28testtask28";

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(String brow) {
        Driver.initBrowser(brow);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Driver.quitBrowser();
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



