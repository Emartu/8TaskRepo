package com.epam.factory_method.steps;


import com.epam.factory_method.base.Driver;
import com.epam.factory_method.business_objects.MailData;
import com.epam.factory_method.pages.NewMailPage;


public class TestNewMailSteps {

    NewMailPage newMailPage = new NewMailPage(Driver.Instance);

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
