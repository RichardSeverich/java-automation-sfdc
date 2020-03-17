package org.fundacionjala.sfdc.pages.acccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;

/**
 * Class containing Product Detail Page.
 */
public class AccountDetail extends DetailBase {

    //Details
    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement accountNameLabel;

    @FindBy(xpath = "//span[text()='Type']/parent::div/following-sibling::div")
    private WebElement typeLabel;

    @FindBy(xpath = "//span[text()='Website']/parent::div/following-sibling::div")
    private WebElement websiteLabel;

    @FindBy(xpath = "//span[text()='Description']/parent::div/following-sibling::div")
    private WebElement descriptionLabel;

    //parent Account /OJO falta
    @FindBy(xpath = "//span[text()='Phone']/parent::div/following-sibling::div")
    private WebElement phoneLabel;

    @FindBy(xpath = "//span[text()='Industry']/parent::div/following-sibling::div")
    private WebElement industryLabel;

    @FindBy(xpath = "//span[text()='Employees']/parent::div/following-sibling::div")
    private WebElement employeesLabel;

    //Address Information.
    @FindBy(xpath = "//span[text()='Billing Address']/parent::div/following-sibling::div")
    private WebElement billingAddressTextLink;

    @FindBy(xpath = "//span[text()='Shipping Address']/parent::div/following-sibling::div")
    private WebElement shippingAddressTextLink;

    @FindBy(xpath = "//span[text()='Details']")
    private WebElement detailClick;

    //Show Details
    @FindBy(xpath = "//button[@title='Edit Shipping Address']")
    private WebElement editShippingAddress;

    @FindBy(xpath = "//button[@title='Edit Billing Address']")
    private WebElement editBillingAddress;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new AccountHome();
    }

    /**
     * Gets the Account Name Text.
     *
     * @return String.
     */
    public String getAccountNameText() {
        return CommonActions.getTextElement(accountNameLabel);
    }

    /**
     * Gets the Type Text.
     *
     * @return String.
     */
    public String getTypeText() {
        return CommonActions.getTextElement(typeLabel);
    }

    /**
     * Gets the Website Text.
     *
     * @return String.
     */
    public String getWebsiteText() {
        return CommonActions.getTextElement(websiteLabel);
    }

    /**
     * Gets the Description Text.
     *
     * @return String.
     */
    public String getDescriptionText() {
        return CommonActions.getTextElement(descriptionLabel);
    }

    /**
     * Gets the Phone Text.
     *
     * @return String.
     */
    public String getPhoneText() {
        return CommonActions.getTextElement(phoneLabel);
    }

    /**
     * Gets the Industry Text.
     *
     * @return String.
     */
    public String getIndustryText() {
        return CommonActions.getTextElement(industryLabel);
    }

    /**
     * Gets the Employees Text.
     *
     * @return String.
     */
    public String getEmployeesText() {
        return CommonActions.getTextElement(employeesLabel);
    }

    /**
     * Gets the Billing Address Text.
     *
     * @return String.
     */
    public String getBillingAddressText() {
        return CommonActions.getTextElement(billingAddressTextLink);
    }

    /**
     * Gets the ShippingAddress Text.
     *
     * @return String.
     */
    public String getShippingAddressText() {
        return CommonActions.getTextElement(shippingAddressTextLink);
    }

    /**
     * Click Detail Button.
     */
    public void clickDetailButton() {
        CommonActions.clickElement(detailClick);
    }

    /**
     * Click Edit Shipping Address.
     */
    public void clickEditShippingAddress() {
        CommonActions.clickElement(editShippingAddress);
    }

    /**
     * Click Edit Billing Address.
     */
    public void clickEditBillingAddress() {
        CommonActions.clickElement(editBillingAddress);
    }
}
