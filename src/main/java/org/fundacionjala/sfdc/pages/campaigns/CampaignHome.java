package org.fundacionjala.sfdc.pages.campaigns;

import org.openqa.selenium.By;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Class containing Campaign Home Page.
 */
public class CampaignHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickNewButton() {
        CommonActions.jsClickCssButton(newButton);
        return new CampaignForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.clickElement(editButton);
        return new CampaignForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetailBase clickDisplayedItem(String name) {
        isDisplayedItem(name);
        CommonActions.clickElement(displayedItem);
        return new CampaignDetail();
    }

    /**
     * Determines if the Product Field Data is displayed on Home Page.
     *
     * @param campaignName  Product Name for row.
     * @param campaignField Product Field like Code, Family.
     * @return boolean.
     */
    public boolean isCampaignFieldDisplayed(String campaignName, String campaignField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                campaignName, campaignField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
