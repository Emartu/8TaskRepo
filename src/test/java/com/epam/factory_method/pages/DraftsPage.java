package com.epam.factory_method.pages;


import com.epam.factory_method.base.Driver;
import com.epam.factory_method.base.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DraftsPage {


    private WebDriver driver = Driver.Instance;

    @FindBy(xpath = "//button[@data-action='save']")
    private WebElement popupSaveButton;

    @FindBy(xpath = "//a[@data-key='view=folder&fid=6']")
    private WebElement draftLink;

    @FindBy(xpath = "//span[@title='sent via WebDriver']")
    private WebElement sentSubj;

    @FindBy(xpath = "//span[@title='sent via WebDriver']")
    private WebElement draftMessage;

    @FindBy(xpath = "//div[@name='to']")
    private WebElement toAdress;

    @FindBy(xpath = "//*[@class='svgicon svgicon-mail--Folder_sent mail-NestedList-Item-Icon']")
    private WebElement sentLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement sendButton;


    public DraftsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickPopUpSaveChanges() {
        popupSaveButton.click();
    }

    public void clickDraftLink() {
        draftLink.click();
    }

    public void openDraftMessage() {
        draftMessage.click();
        WaitTool.waitForElementPresent(driver, new By.ByXPath("//button[@type='submit']"), 5);
    }

    public void sendTheMail() {
        sendButton.click();
    }

    public void clickOnSentMail() {
        sentLink.click();
    }

    public boolean verifyMessageIsInSent() {
        try {
            WebElement element = driver.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

