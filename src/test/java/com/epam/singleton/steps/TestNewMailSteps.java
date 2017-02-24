package com.epam.singleton.steps;


import com.epam.singleton.base.Driver;
import com.epam.singleton.business_objects.MailData;
import com.epam.singleton.pages.NewMailPage;

public class TestNewMailSteps {

    NewMailPage newMailPage = new NewMailPage(Driver.Initialize());

    public void createNewMail(MailData mailData) {
        newMailPage.clickCreateNewMail();
        newMailPage.setToAdress(mailData.getTo());
        newMailPage.setMailSubject(mailData.getSubject());
    }

    public void goDrafts() {
        newMailPage.clickDraftLink();
    }

    public boolean isMessageSent() {
        return newMailPage.messageIsInDraft();
    }
}
