package org.fundacionjala.sfdc.pages.opportunities;

import java.util.EnumMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.IStrategySteps;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * Class containing Opportunity Form Page..
 */
public class OpportunityForm extends FormBase {

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/following-sibling::input")
    private WebElement opportunityNameInputField;

    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div")
    private WebElement opportunityAccountNameInputField;

    @FindBy(css = ".lookup__list .lookup__item.default.uiAutocompleteOption.forceSearchInputLookupDesktopOption > a")
    private WebElement selectOpportunityAccountNameInputField;

    @FindBy(xpath = "//span[contains(text(),'Type')]/parent::span/following-sibling::div/descendant::a")
    private WebElement opportunityTypeInputField;

    @FindBy(xpath = "//span[contains(text(),'Primary Campaign Source')]/parent::label"
            + "/following-sibling::div/descendant::input")
    private WebElement opportunityCampaignInputField;

    @FindBy(xpath = "//span[contains(text(),'Close Date')]/parent::label/following-sibling::div")
    private WebElement opportunityDateInputField;

    @FindBy(css = ".today.slds-show--inline-block")
    private WebElement selectOpportunityDateInputField;

    @FindBy(css = ".uiMenu.uiInput")
    private WebElement opportunityStageInputField;

    @FindBy(xpath = "//span[contains(text(),'Probability (%)')]/parent::label/following-sibling::input")
    private WebElement opportunityProbabilityInputField;

    @FindBy(xpath = "//span[contains(text(),'Amount')]/parent::label/following-sibling::input")
    private WebElement opportunityAmountInputField;

    @FindBy(xpath = "//span[contains(text(),'Budget Confirmed')]/parent::label/following-sibling::input")
    private WebElement opportunityBubgeCheckBox;

    @FindBy(xpath = "//span[contains(text(),'Discovery Completed')]/parent::label/following-sibling::input")
    private WebElement opportunityDiscoveryCheckBox;

    @FindBy(xpath = "//span[contains(text(),'ROI Analysis Completed')]/parent::label/following-sibling::input")
    private WebElement opportunityRoiCheckBox;

    @FindBy(xpath = "//span[contains(text(),'Loss Reason')]/parent::span/following-sibling::div/descendant::a")
    private WebElement opportunityLossReasonInputField;

    @FindBy(xpath = "//span[contains(text(),'Lead Source')]/parent::span/following-sibling::div/descendant::a")
    private WebElement opportunityLeadInputField;

    @FindBy(xpath = "//span[contains(text(),'Next Step')]/parent::label/following-sibling::input")
    private WebElement opportunityNextStepInputField;

    @FindBy(xpath = "//span[contains(text(),'Description')]/parent::label/following-sibling::textarea")
    private WebElement opportunityDescriptionInputField;

    @FindBy(css = "button[title='Save']")
    private WebElement saveOpportunityButton;

    @FindBy(className = "errorsList")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[contains(text(),'Account Name')]/ancestor::div/following-sibling::ul")
    private WebElement errorFieldInvalidAccount;

    @FindBy(xpath = "//span[contains(text(),'Primary Campaign Source')]/ancestor::div/following-sibling::ul")
    private WebElement errorFieldInvalidCampaign;


    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * @param opportunityName field.
     * @return this.
     */
    public OpportunityForm setOpportunityNameInputText(String opportunityName) {
        CommonActions.setInputField(opportunityNameInputField, opportunityName);
        return this;
    }

    /**
     * This method perform a click in the account name text box.
     */
    public void clickAccountName() {
        CommonActions.clickElement(opportunityAccountNameInputField);
    }

    /**
     * @param accountName field.
     * @return this.
     */
    public OpportunityForm setAccountNameSelect(String accountName) {
        clickDeleteAccountIcon(accountName);
        clickAccountName();
        CommonActions.clickElement(selectedDivFormElement(accountName));

        return this;
    }

    /**
     * @param opportunityType field.
     * @return this.
     */
    public OpportunityForm setTypeSelect(String opportunityType) {
        CommonActions.clickElement(opportunityTypeInputField);
        selectedAformElement(opportunityType);
        return this;
    }

    /**
     * This method perform a click in the campaign input name.
     */
    public void clickCampaignInputName() {
        CommonActions.clickElement(opportunityCampaignInputField);
    }

    /**
     * @param campaignName field.
     * @return this.
     */
    public OpportunityForm setPrimaryCampaignSourceSelect(String campaignName) {
        clickCampaignInputName();
        CommonActions.clickElement(selectedDivFormElement(campaignName));
        return this;
    }

    /**
     * @return this.
     */
    public OpportunityForm setCloseDateSelect() {

        CommonActions.clickElement(opportunityDateInputField);
        CommonActions.clickElement(selectOpportunityDateInputField);

        return this;
    }

    /**
     * @param stage field.
     * @return this.
     */
    public OpportunityForm setStageSelect(String stage) {

        CommonActions.clickElement(opportunityStageInputField);
        selectedAformElement(stage);

        return this;
    }

    /**
     * @param probability field.
     * @return this.
     */
    public OpportunityForm setProbabilityInputText(String probability) {
        CommonActions.setInputField(opportunityProbabilityInputField, probability);
        return this;
    }

    /**
     * @param flag boolean.
     */
    private void setBudgetConfirmedCheckBox(boolean flag) {
        CommonActions.setCheckBox(opportunityBubgeCheckBox, flag);
    }

    /**
     * @param flag boolean.
     */
    private void setDiscoveryCompletedCheckBox(boolean flag) {
        CommonActions.setCheckBox(opportunityDiscoveryCheckBox, flag);
    }

    /***
     *
     * @param flag boolean.
     */
    private void setRoiAnalysisCompletedCheckBox(boolean flag) {
        CommonActions.setCheckBox(opportunityRoiCheckBox, flag);
    }

    /**
     * @param amount field.
     * @return this.
     */
    public OpportunityForm setAmountInputText(String amount) {

        CommonActions.setInputField(opportunityAmountInputField, amount);
        return this;
    }

    /**
     * @param lossReason field.
     * @return this.
     */
    public OpportunityForm setLossReasonSelect(String lossReason) {
        CommonActions.clickElement(opportunityLossReasonInputField);
        selectedAformElement(lossReason);
        return this;
    }

    /**
     * @param lead field.
     * @return this.
     */
    public OpportunityForm setLeadSourceSelect(String lead) {

        CommonActions.clickElement(opportunityLeadInputField);
        selectedAformElement(lead);
        return this;
    }

    /**
     * @param nextStep field.
     * @return this.
     */
    public OpportunityForm setNextStepInputText(String nextStep) {

        CommonActions.setInputField(opportunityNextStepInputField, nextStep);
        return this;
    }

    /**
     * @param description field.
     * @return this.
     */
    public OpportunityForm setDescriptionTextArea(String description) {
        CommonActions.setInputField(opportunityDescriptionInputField, description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public DetailBase setObject(Map<OpportunityFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new OpportunityDetail();
    }

    /**
     * @param formMap strategy.
     * @return strategyMap.
     */
    private Map<OpportunityFormField, IStrategySteps> getStrategyMap(Map<OpportunityFormField, String> formMap) {
        EnumMap<OpportunityFormField, IStrategySteps> strategyMap = new EnumMap<>(OpportunityFormField.class);

        strategyMap.put(OpportunityFormField.OPPORTUNITY_NAME,
                () -> setOpportunityNameInputText(formMap.get(OpportunityFormField.OPPORTUNITY_NAME)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_ACCOUNT,
                () -> setAccountNameSelect(formMap.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));

        strategyMap.put(OpportunityFormField.DATE, this::setCloseDateSelect);

        strategyMap.put(OpportunityFormField.OPPORTUNITY_TYPE,
                () -> setTypeSelect(formMap.get(OpportunityFormField.OPPORTUNITY_TYPE)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_PROBABILITY,
                () -> setProbabilityInputText(formMap.get(OpportunityFormField.OPPORTUNITY_PROBABILITY)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_CAMPAIGN,
                () -> setPrimaryCampaignSourceSelect(formMap.get(OpportunityFormField.OPPORTUNITY_CAMPAIGN)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_AMOUNT,
                () -> setAmountInputText(formMap.get(OpportunityFormField.OPPORTUNITY_AMOUNT)));

        strategyMap.put(OpportunityFormField.BUDGE,
                () -> setBudgetConfirmedCheckBox(Boolean.parseBoolean(formMap.get(OpportunityFormField.BUDGE))));

        strategyMap.put(OpportunityFormField.DISCOVERY,
                () -> setDiscoveryCompletedCheckBox(Boolean.parseBoolean(formMap.get(OpportunityFormField.DISCOVERY))));

        strategyMap.put(OpportunityFormField.ROI,
                () -> setRoiAnalysisCompletedCheckBox(Boolean.parseBoolean(formMap.get(OpportunityFormField.ROI))));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_REASON,
                () -> setLossReasonSelect(formMap.get(OpportunityFormField.OPPORTUNITY_REASON)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_LEAD,
                () -> setLeadSourceSelect(formMap.get(OpportunityFormField.OPPORTUNITY_LEAD)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_NEXT,
                () -> setNextStepInputText(formMap.get(OpportunityFormField.OPPORTUNITY_NEXT)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_DESCRIPTION,
                () -> setDescriptionTextArea(formMap.get(OpportunityFormField.OPPORTUNITY_DESCRIPTION)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_STAGE,
                () -> setStageSelect(formMap.get(OpportunityFormField.OPPORTUNITY_STAGE)));
        return strategyMap;
    }

    /**
     * @param element web.
     */
    public void selectedAformElement(String element) {
        String selector = String.format("//a[contains(@title,'%s')]", element);
        driver.findElement(By.xpath(selector)).click();
    }

    /**
     * Selected Div Form Element.
     *
     * @param element String.
     * @return WebElement.
     */
    public WebElement selectedDivFormElement(String element) {
        String selector = String.format("div[title = '%s']", element);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }

    /**
     * {@inheritDoc}
     */
    public OpportunityDetail fillAndSaveForm(Map<OpportunityFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new OpportunityDetail();
    }

    /**
     * @param accountName field.
     */
    public void clickDeleteAccountIcon(String accountName) {
        String xpathSelector = String.format("//span[text()='%s']/following-sibling::a/"
                + "child::span[@class='deleteIcon']", accountName);
        try {
            DriverManager.getInstance().setUpdateWait(3);
            driver.findElement(By.xpath(xpathSelector)).click();
        } catch (NotFoundException e) {
            LOGGER.error("Timeout exception triggered");
            LOGGER.info(e);
        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
    }

    /**
     * This method verify error message.
     *
     * @param message is error message.
     * @return if message is correct.
     */
    public Boolean messageIsDisplayed(String message) {
        return errorMessage.getText().contains(message);
    }

    /**
     * This method verify error message.
     *
     * @param error is error.
     * @return if message is correct.
     */
    public boolean messageFieldInvalidIsDisplayed(String error) {
        return errorFieldInvalidAccount.getText().contains(error)
                && errorFieldInvalidCampaign.getText().contains(error);
    }
}
