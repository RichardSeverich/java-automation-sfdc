package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;

/**
 * Abstract class that gets common info in Form Page.
 */
public abstract class FormBase extends BasePage {

    @FindBy(css = ".modal-footer button[title='Save']")
    protected WebElement saveButton;

    @FindBy(css = ".modal-footer button[title='Save & New']")
    protected WebElement saveAndNewButton;

    @FindBy(css = ".modal-footer button[title='Cancel']")
    protected WebElement cancelButton;

    @FindBy(xpath = "//ul[@class='errorsList']/child::li")
    protected WebElement requiredFieldsText;

    @FindBy(xpath = "//button[contains(@class, 'slds-button slds-modal__close closeIcon ')]")
    protected WebElement closeButton;

    /**
     * Clicks the Save Button of the Form.
     */
    public void clickSaveButton() {
        CommonActions.clickElement(saveButton);
    }

    /**
     * Clicks the close form button.
     */
    public void clickCloseButton() {
        CommonActions.clickElement(closeButton);
    }

    /**
     * Clicks the Save and New Button of the Form.
     */
    public void clickSaveAndNewButton() {
        CommonActions.clickElement(saveAndNewButton);
    }

    /**
     * Clicks the Cancel Button of the Form.
     */
    public void clickCancelButton() {
        CommonActions.clickElement(cancelButton);
    }

    /**
     * Return the complete text of the error notification.
     *
     * @return error notification content.
     */
    public String errorNotificationText() {
        return CommonActions.getTextElement(requiredFieldsText);
    }
}
