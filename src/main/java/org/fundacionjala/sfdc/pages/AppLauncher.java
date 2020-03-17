package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.acccounts.AccountHome;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.fundacionjala.sfdc.pages.campaigns.CampaignHome;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Class for the App Launcher.
 */
public class AppLauncher extends BasePage {

    @FindBy(css = ".modal-header")
    private WebElement windowModal;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Products']")
    private WebElement productsTextLink;

    @FindBy(css = ".salesforceIdentityAppLauncherDesktopInternal .uiButton")
    private WebElement openAllAppsButton;

    @FindBy(xpath = "//button[@class='slds-button']")
    private WebElement openAllItemsButton;

    @FindBy(css = "a[title='Chatter']")
    private WebElement chatterButton;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Accounts']")
    private WebElement accountsTextLink;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Opportunities']")
    private WebElement opportunitiesTextLink;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Campaigns']")
    private WebElement campaignTextLink;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Chatter']")
    private WebElement chatterTextLink;

    @FindBy(css = "a[title='Opportunities']")
    private WebElement opportunityButton;

    /**
     * Waits for the modal is displayed.
     */
    private void waitModal() {
        CommonActions.isElementDisplayed(windowModal);
    }

    /**
     * Clicks the Product Text Link.
     *
     * @return ProductHome.
     */
    public ProductHome clickProductsTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(productsTextLink);
        return new ProductHome();
    }

    /**
     * Clicks the Chatter Text Link.
     *
     * @return PostForm
     */
    public PostForm clickChatterTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(chatterTextLink);
        return new PostForm();
    }

    /**
     * Clicks the Product Text Link.
     *
     * @return ProductHome.
     */
    public AccountHome clickAccountTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(accountsTextLink);
        return new AccountHome();
    }

    /**
     * Clicks the Opportunity Text Link.
     *
     * @return OpportunityHome.
     */
    public OpportunityHome clickOpportunityTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(opportunitiesTextLink);
        return new OpportunityHome();
    }

    /**
     * Clicks the Opportunity Button.
     *
     * @return OpportunityHome.
     */
    public OpportunityHome clickOpportunityButton() {
        CommonActions.clickElement(opportunityButton);
        return new OpportunityHome();
    }

    /**
     * Clicks the Campaign Text Link.
     *
     * @return CampaignHome.
     */
    public CampaignHome clickCampaignTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(campaignTextLink);
        return new CampaignHome();
    }
}
