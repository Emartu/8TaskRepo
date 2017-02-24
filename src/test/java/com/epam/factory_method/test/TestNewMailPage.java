package com.epam.factory_method.test;

import com.epam.factory_method.base.Driver;
import com.epam.factory_method.business_objects.MailData;
import com.epam.factory_method.business_objects.User;
import com.epam.factory_method.steps.TestLoginSteps;
import com.epam.factory_method.steps.TestNewMailSteps;
import com.epam.factory_method.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNewMailPage {

    private TestLoginSteps testLoginSteps;
    private TestNewMailSteps testNewMailSteps;
    private String login = "testtask28";
    private String password = "testtask28testtask28";
    private String to = "emartu@yandex.ru";
    private String subject = "sent via WebDriver";
    private String body = "testtask28testtask28";

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(String brow) {
        Driver.initBrowser(brow);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Driver.quitBrowser();
    }

    @DataProvider(name = "NewMail_Provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {new User(login, password), new MailData(to, subject, body)}
        };
    }

    @Test(dataProvider = "NewMail_Provider", groups = "Mail Page Test", description = "Tests whether email is sent")
    public void testMailIsInDraft(User user, MailData mailData) {
        testLoginSteps = new TestLoginSteps();
        testNewMailSteps = new TestNewMailSteps();
        testLoginSteps.openMailWebAddress(TestInput.mailBoxUrl);
        testLoginSteps.doLogin(user);
        testNewMailSteps.createNewMail(mailData);
        testNewMailSteps.goDrafts();
        Assert.assertTrue(testNewMailSteps.isMessageSent(), "Element is not found, seems like message is not saved in Drafts ... ");
    }

}
