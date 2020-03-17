package org.fundacionjala.sfdc.pages.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;

/**
 * Class containing Opportunity Detail Page.
 */
public class OpportunityDetail extends DetailBase {

    @FindBy(xpath = "//p[contains(text(), 'Opportunity')]/following-sibling::h1")
    private WebElement opportunityNameText;

    @FindBy(xpath = "//p[contains(text(), 'Account Name')]/following-sibling::p/descendant::a")
    private WebElement accountNameText;

    @FindBy(xpath = "//p[contains(text(), 'Close Date')]/following-sibling::P")
    private WebElement closeDateText;

    @FindBy(xpath = " //p[contains(text(), 'Amount')]/following-sibling::P")
    private WebElement amountText;

    @FindBy(xpath = "//span[contains(@class,'current')]/following-sibling::span")
    private WebElement stageText;

    @FindBy(className = "errorsList")
    private WebElement errorMessage;


    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new OpportunityHome();
    }

    /**
     * Gets the Opportunity Name Text.
     *
     * @return String.
     */
    public String getOpportunityNameText() {
        return CommonActions.getTextElement(opportunityNameText);
    }

    /**
     * Gets the Opportunity Account Text.
     *
     * @return String.
     */
    public String getOpportunityAccountText() {
        return CommonActions.getTextElement(accountNameText);
    }

    /**
     * Gets the Opportunity Close date Text.
     *
     * @return String.
     */
    public String getOpportunityCloseDateText() {
        return closeDateText.getText();
    }

    /**
     * Gets the Opportunity Amount Text.
     *
     * @return String.
     */
    public String getOpportunityAmountText() {
        return amountText.getText();
    }

}

