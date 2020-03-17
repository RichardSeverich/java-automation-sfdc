package org.fundacionjala.sfdc.pages.acccounts;

import java.util.EnumMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.IStrategySteps;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * Class to Account Form.
 */
public class AccountForm extends FormBase {

    private static final Logger LOGGER = LogManager.getLogger();

    //Account Information
    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div/descendant::input")
    private WebElement accountNameNewInputField;

    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::input")
    private WebElement accountNameEditInputField;

    @FindBy(xpath = "//span[contains(text(),'Type')]/parent::span/following-sibling::div/descendant::a")
    private WebElement typeDropDownList;

    @FindBy(xpath = "//span[text()='Website']/parent::label/following-sibling::input")
    private WebElement websiteInputField;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    private WebElement descriptionInputField;

    @FindBy(xpath = "//span[text()='Parent Account']/parent::label/following-sibling::div")
    private WebElement parentAccountSearch;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    private WebElement phoneInputField;

    @FindBy(xpath = "//span[text()='Industry']/parent::span/following-sibling::div/descendant::a")
    private WebElement industryDropDownList;

    @FindBy(xpath = "//span[text()='Employees']/parent::label/following-sibling::input")
    private WebElement employeesInputField;

    //Address Information
    @FindBy(xpath = "//span[text()='Billing Street']/parent::label/following-sibling::textarea")
    private WebElement billingStreetTextArea;

    @FindBy(xpath = "//span[text()='Billing City']/parent::label/following-sibling::input")
    private WebElement billingCityInputField;

    @FindBy(xpath = "//span[text()='Billing Zip/Postal Code']/parent::label/following-sibling::input")
    private WebElement billingZipInputField;

    @FindBy(xpath = "//span[text()='Billing State/Province']/parent::label/following-sibling::input")
    private WebElement billingStateInputField;

    @FindBy(xpath = "//span[text()='Billing Country']/parent::label/following-sibling::input")
    private WebElement billingCountryInputField;

    @FindBy(xpath = "//span[text()='Shipping Street']/parent::label/following-sibling::textarea")
    private WebElement shippingStreetInputField;

    @FindBy(xpath = "//span[text()='Shipping City']/parent::label/following-sibling::input")
    private WebElement shippingCityInputField;

    @FindBy(xpath = "//span[text()='Shipping Zip/Postal Code']/parent::label/following-sibling::input")
    private WebElement shippingZipInputField;

    @FindBy(xpath = "//span[text()='Shipping State/Province']/parent::label/following-sibling::input")
    private WebElement shippingStateInputField;

    @FindBy(xpath = "//span[text()='Shipping Country']/parent::label/following-sibling::input")
    private WebElement shippingCountryInputField;

    @FindBy(css = "button[title='Save']")
    private WebElement saveAccountButton;

    @FindBy(xpath = "//div[@title='Edit']")
    private WebElement selectParent;

    /**
     * {@inheritDoc}
     */
    public AccountDetail newItem(String name) {
        setAccountNameInputText(name);
        clickSaveButton();
        return new AccountDetail();
    }

    //Account Information

    /**
     * Set Account Name.
     *
     * @param accountName String.
     */
    private void setAccountNameInputText(String accountName) {
        try {
            DriverManager.getInstance().setUpdateWait(3);
            CommonActions.setInputField(accountNameNewInputField, accountName);
        } catch (TimeoutException | NoSuchElementException e) {
            CommonActions.setInputField(accountNameEditInputField, accountName);
            LOGGER.error("Timeout exception triggered");
            LOGGER.info(e);
        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
    }

    /**
     * Set Type.
     *
     * @param type String.
     */
    private void setTypeDropDownList(String type) {
        CommonActions.clickElement(typeDropDownList);
        String cssSelector = String.format("a[title='%s']", type);
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    /**
     * Set Website.
     *
     * @param webSite String.
     */
    private void setWebsiteInputText(String webSite) {
        CommonActions.setInputField(websiteInputField, webSite);
    }

    /**
     * Set Description.
     *
     * @param description String.
     */
    private void setDescriptionInputText(String description) {
        CommonActions.setInputField(descriptionInputField, description);
    }

    /**
     * Set Phone.
     *
     * @param phone String.
     */
    private void setPhoneInputText(String phone) {
        CommonActions.setInputField(phoneInputField, phone);
    }

    /**
     * Set Industry.
     *
     * @param industry String.
     */
    private void setIndustryDropDownList(String industry) {
        CommonActions.clickElement(industryDropDownList);
        String cssSelector = String.format("a[title='%s']", industry);
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    /**
     * Set Employees.
     *
     * @param employees String.
     */
    private void setEmployeesInputText(String employees) {
        CommonActions.setInputField(employeesInputField, employees);
    }

    //Address Information

    /**
     * Set Billing Street.
     *
     * @param billingStreet String.
     */
    private void setBillingStreetInputText(String billingStreet) {
        CommonActions.setInputField(billingStreetTextArea, billingStreet);
    }

    /**
     * Set Billing City.
     *
     * @param billingCity String.
     */
    private void setBillingCityInputText(String billingCity) {
        CommonActions.setInputField(billingCityInputField, billingCity);
    }

    /**
     * Set Billing Zip.
     *
     * @param billingZip String.
     */
    private void setBillingZipInputText(String billingZip) {
        CommonActions.setInputField(billingZipInputField, billingZip);
    }

    /**
     * Set Billing State.
     *
     * @param billingState String.
     */
    private void setBillingStateInputText(String billingState) {
        CommonActions.setInputField(billingStateInputField, billingState);
    }

    /**
     * Set Billing Country.
     *
     * @param billingCountry String.
     */
    private void setBillingCountryInputText(String billingCountry) {
        CommonActions.setInputField(billingCountryInputField, billingCountry);
    }

    /**
     * Set Shipping Street.
     *
     * @param shippingStreet String.
     */
    private void setShippingStreetInputText(String shippingStreet) {
        CommonActions.setInputField(shippingStreetInputField, shippingStreet);
    }

    /**
     * Set Shipping City.
     *
     * @param shippingCity String.
     */
    private void setShippingCityInputText(String shippingCity) {
        CommonActions.setInputField(shippingCityInputField, shippingCity);
    }

    /**
     * Set Shipping Zip.
     *
     * @param shippingZip String.
     */
    private void setShippingZipInputText(String shippingZip) {
        CommonActions.setInputField(shippingZipInputField, shippingZip);
    }

    /**
     * Set Shipping State.
     *
     * @param shippingState String.
     */
    private void setShippingStateInputText(String shippingState) {
        CommonActions.setInputField(shippingStateInputField, shippingState);
    }

    /**
     * Set Shipping Country.
     *
     * @param shippingCountry String.
     */
    private void setShippingCountryInputText(String shippingCountry) {
        CommonActions.setInputField(shippingCountryInputField, shippingCountry);
    }

    /**
     * Gets the current Map from Steps Definition.
     *
     * @param formMap Map<AccountFormField, String>.
     * @return Map AccountFormField, IStrategySteps.
     */
    private Map<AccountFormField, IStrategySteps> getStrategyMap(Map<AccountFormField, String> formMap) {
        EnumMap<AccountFormField, IStrategySteps> strategyMap = new EnumMap<>(AccountFormField.class);
        strategyMap.put(AccountFormField.ACCOUNT_NAME,
                () -> setAccountNameInputText(formMap.get(AccountFormField.ACCOUNT_NAME)));
        strategyMap.put(AccountFormField.ACCOUNT_TYPE,
                () -> setTypeDropDownList(formMap.get(AccountFormField.ACCOUNT_TYPE)));
        strategyMap.put(AccountFormField.ACCOUNT_WEBSITE,
                () -> setWebsiteInputText(formMap.get(AccountFormField.ACCOUNT_WEBSITE)));
        strategyMap.put(AccountFormField.ACCOUNT_DESCRIPTION,
                () -> setDescriptionInputText(formMap.get(AccountFormField.ACCOUNT_DESCRIPTION)));
        strategyMap.put(AccountFormField.ACCOUNT_PHONE,
                () -> setPhoneInputText(formMap.get(AccountFormField.ACCOUNT_PHONE)));
        strategyMap.put(AccountFormField.ACCOUNT_INDUSTRY,
                () -> setIndustryDropDownList(formMap.get(AccountFormField.ACCOUNT_INDUSTRY)));
        strategyMap.put(AccountFormField.ACCOUNT_EMPLOYEES,
                () -> setEmployeesInputText(formMap.get(AccountFormField.ACCOUNT_EMPLOYEES)));
        strategyMap.put(AccountFormField.ACCOUNT_BILLING_STREET,
                () -> setBillingStreetInputText(formMap.get(AccountFormField.ACCOUNT_BILLING_STREET)));
        strategyMap.put(AccountFormField.ACCOUNT_BILLING_CITY,
                () -> setBillingCityInputText(formMap.get(AccountFormField.ACCOUNT_BILLING_CITY)));
        strategyMap.put(AccountFormField.ACCOUNT_BILLING_ZIP,
                () -> setBillingZipInputText(formMap.get(AccountFormField.ACCOUNT_BILLING_ZIP)));
        strategyMap.put(AccountFormField.ACCOUNT_BILLING_STATE,
                () -> setBillingStateInputText(formMap.get(AccountFormField.ACCOUNT_BILLING_STATE)));
        strategyMap.put(AccountFormField.ACCOUNT_BILLING_COUNTRY,
                () -> setBillingCountryInputText(formMap.get(AccountFormField.ACCOUNT_BILLING_COUNTRY)));
        strategyMap.put(AccountFormField.ACCOUNT_SHIPPING_STREET,
                () -> setShippingStreetInputText(formMap.get(AccountFormField.ACCOUNT_SHIPPING_STREET)));
        strategyMap.put(AccountFormField.ACCOUNT_SHIPPING_CITY,
                () -> setShippingCityInputText(formMap.get(AccountFormField.ACCOUNT_SHIPPING_CITY)));
        strategyMap.put(AccountFormField.ACCOUNT_SHIPPING_ZIP,
                () -> setShippingZipInputText(formMap.get(AccountFormField.ACCOUNT_SHIPPING_ZIP)));
        strategyMap.put(AccountFormField.ACCOUNT_SHIPPING_STATE,
                () -> setShippingStateInputText(formMap.get(AccountFormField.ACCOUNT_SHIPPING_STATE)));
        strategyMap.put(AccountFormField.ACCOUNT_SHIPPING_COUNTRY,
                () -> setShippingCountryInputText(formMap.get(AccountFormField.ACCOUNT_SHIPPING_COUNTRY)));
        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    public AccountDetail fillAndSaveForm(Map<AccountFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new AccountDetail();
    }
}
