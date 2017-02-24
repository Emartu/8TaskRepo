package com.epam.singleton.steps;


import com.epam.singleton.base.Driver;
import com.epam.singleton.base.WaitTool;
import com.epam.singleton.business_objects.MailData;
import com.epam.singleton.pages.DraftsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestDraftSteps {

    DraftsPage draftsPage = new DraftsPage(Driver.Initialize());


    public void sendFromDrafts() {
        draftsPage.clickDraftLink();
        draftsPage.clickPopUpSaveChanges();
        draftsPage.openDraftMessage();
        draftsPage.sendTheMail();
        draftsPage.clickOnSentMail();
    }

    public boolean verifyMessageIsSent() {
        return draftsPage.verifyMessageIsInSent();
    }
}
