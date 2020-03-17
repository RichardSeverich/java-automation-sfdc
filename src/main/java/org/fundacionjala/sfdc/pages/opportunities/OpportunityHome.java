package org.fundacionjala.sfdc.pages.opportunities;

import org.openqa.selenium.By;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Class containing Opportunity Home Page.
 */
public class OpportunityHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickNewButton() {
        return workaroundOpportunityForm();
    }

    /**
     * This method perform the actions for the workaround and prevent that the
     * account name and the campaign name not appear in the form.
     *
     * @return opportunity form instance.
     */
    private OpportunityForm workaroundOpportunityForm() {
        OpportunityForm opportunityForm = new OpportunityForm();
        CommonActions.jsClickCssButton(newButton);
        opportunityForm.clickCampaignInputName();
        opportunityForm.clickAccountName();
        opportunityForm.clickCloseButton();
        CommonActions.jsClickCssButton(newButton);
        return opportunityForm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.clickElement(editButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetailBase clickDisplayedItem(String name) {
        isDisplayedItem(name);
        CommonActions.clickElement(displayedItem);
        return new OpportunityDetail();
    }

    /**
     * Determines if the Opportunity Field Data is displayed on Home Page.
     *
     * @param opportunityName  Opportunity Name for row.
     * @param opportunityField Opportunity Field like Code, Family.
     * @return boolean.
     */
    public boolean isOpportunityFieldDisplayed(String opportunityName, String opportunityField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                opportunityName, opportunityField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }

    /**
     * @param opportunityName  field.
     * @param opportunityField field.
     * @return driver.
     */
    public boolean isOpportunityLinkDisplayed(String opportunityName, String opportunityField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::a[text()='%s']",
                opportunityName, opportunityField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
