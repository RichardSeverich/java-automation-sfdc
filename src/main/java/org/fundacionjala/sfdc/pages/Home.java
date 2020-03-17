package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.BasePage;

/**
 * Class for the Home Page.
 */
public class Home extends BasePage {

    //All WebElements are identified by @FindBy annotation.
    @FindBy(css = ".oneUserProfileCardTrigger")
    private WebElement viewProfileIcon;

    @FindBy(css = ".oneUserProfileCard .logout")
    private WebElement logOutButton;

    @FindBy(css = "h1.profile-card-name > a.profile-link-label")
    private WebElement nameProfileLabel;

    @FindBy(css = "div.profile-card-toplinks > a.profile-link-label")
    private WebElement settingButton;

    @FindBy(id = "error")
    private WebElement errorMessageId;

    @FindBy(css = ".profile-link-label.profile-photo")
    private WebElement profileLinkLabel;

    @FindBy(css = "a[href='#/home']")
    private WebElement homeLink;

    @FindBy(className = "slds-icon-waffle")
    private WebElement appLauncherButton;


    /**
     * Wait for page load and get the title from Home Page.
     *
     * @return Url current.
     */
    public String getTitleHomePage() {
        wait.until(ExpectedConditions.titleContains("| Salesforce"));
        return driver.getCurrentUrl();
    }

    /**
     * Method that make a click on the profile icon.
     */
    public void clickProfileIcon() {
        CommonActions.clickElement(viewProfileIcon);
    }

    /**
     * Method that get the username of the main page.
     *
     * @return name profile label of the user.
     */
    public String getUserNameOfHomePage() {
        clickProfileIcon();
        return CommonActions.getTextElement(nameProfileLabel);
    }

    /**
     * This method verify that error message is Displayed.
     *
     * @return True if the element is Displayed.
     */
    public boolean isErrorMessageDisplayed() {
        return CommonActions.isElementDisplayed(errorMessageId);
    }

    /**
     * Method that makes click on logout link.
     */
    public void clickLogOutLink() {
        clickProfileIcon();
        CommonActions.clickElement(logOutButton);
    }

    /**
     * This method make  click on Profile link label.
     *
     * @return Profile pageObject.
     */
    public Profile clickProfileLinkLabel() {
        clickProfileIcon();
        CommonActions.clickElement(profileLinkLabel);
        return new Profile();
    }

    /**
     * This method make click on Home link label.
     *
     * @return Home pageObject.
     */
    public Home clickHomeLink() {
        CommonActions.clickElement(homeLink);
        return new Home();
    }

    /**
     * Loads the App Launcher by clicking on its button.
     *
     * @return AppLauncher.
     */
    public AppLauncher clickAppLauncher() {
        CommonActions.jsClickClassButton(appLauncherButton);
        return new AppLauncher();
    }
}
