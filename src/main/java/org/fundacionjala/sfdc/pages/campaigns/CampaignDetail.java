package org.fundacionjala.sfdc.pages.campaigns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Class containing Campaign Detail Page.
 */
public class CampaignDetail extends DetailBase {

    @FindBy(xpath = "//p[contains(text(), 'Campaign')]/following-sibling::h1")
    private WebElement campaignNameText;

    /**
     * Gets the Campaign Name Text.
     *
     * @return String.
     */
    public String getCampaignNameText() {
        return campaignNameText.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton() {
        CommonActions.clickElement(editButton);
        return new CampaignForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HomeBase deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new CampaignHome();
    }
}
