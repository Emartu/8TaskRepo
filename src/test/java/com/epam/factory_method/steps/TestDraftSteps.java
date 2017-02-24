package com.epam.factory_method.steps;


import com.epam.factory_method.base.Driver;
import com.epam.factory_method.base.WaitTool;
import com.epam.factory_method.pages.DraftsPage;
import org.openqa.selenium.By;


public class TestDraftSteps {


    DraftsPage draftsPage = new DraftsPage(Driver.Instance);

    public void sendFromDrafts() {

        draftsPage.clickDraftLink();
        draftsPage.clickPopUpSaveChanges();
        draftsPage.openDraftMessage();
        WaitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//button[@type='submit']"), 10);
        draftsPage.sendTheMail();
        draftsPage.clickOnSentMail();
    }

    public boolean verifyMessageIsSent() {
        return draftsPage.verifyMessageIsInSent();
    }
}
