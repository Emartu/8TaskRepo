package com.epam.singleton.test;

import com.epam.singleton.business_objects.User;
import com.epam.singleton.base.Driver;
import com.epam.singleton.business_objects.MailData;
import com.epam.singleton.steps.TestLoginSteps;
import com.epam.singleton.steps.TestNewMailSteps;
import com.epam.singleton.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestNewMailPage {

    private TestLoginSteps testLoginSteps;
    private TestNewMailSteps testNewMailSteps;
    private String login = "testtask28";
    private String password = "testtask28testtask28";
    private String to = "emartu@yandex.ru";
    private String subject = "sent via WebDriver";
    private String body = "testtask28testtask28";

    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Driver.quit();
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
