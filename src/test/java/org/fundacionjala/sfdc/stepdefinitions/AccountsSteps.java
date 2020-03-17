package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.When;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.acccounts.AccountDetail;
import org.fundacionjala.sfdc.pages.acccounts.AccountForm;
import org.fundacionjala.sfdc.pages.acccounts.AccountFormField;
import org.fundacionjala.sfdc.pages.acccounts.AccountHome;

/**
 * Create Steps for Accounts.
 */
public class AccountsSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public AccountsSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Account Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Account form with:$")
    public void iFillTheAccountFormWith(Map<AccountFormField, String> formMapData) {
        helper.setItemName(formMapData.get(AccountFormField.ACCOUNT_NAME));
        helper.setAccountMap(formMapData);
        new AccountForm().fillAndSaveForm(helper.getAccountMap());
        new AccountHome().waitUntilSpinnerIsHidden();
    }

    /**
     * Click on Edit from Account.
     */
    @When("^I click on Edit from Account$")
    public void iClickOnEditFromAccount() {
        new AccountDetail().clickEditButton();
    }

    /**
     * Click on Delete from Account.
     */
    @When("^I Click on Delete from Account$")
    public void iClickOnDeleteFromAccount() {
        new AccountDetail().deleteItem();
    }
}
