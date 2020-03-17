package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.SObject;
import org.fundacionjala.sfdc.pages.acccounts.AccountForm;

/**
 * Common assert step definitions.
 */
public class CommonAssertionSteps {

    private Helper helper;

    private Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CommonAssertionSteps(Helper helper) {
        this.helper = helper;
        assertion = this.helper.getAssertion();
    }

    /**
     * This method executes all soft asserts.
     */
    @And("^Assert all$")
    public void assertAll() {
        if (assertion instanceof SoftAssert) {
            ((SoftAssert) assertion).assertAll();
        }
    }

    /**
     * Assertion step to verify the error message displayed.
     *
     * @param msg     error message that should be displayed in a Form Page.
     * @param sObject SObject enum parameter.
     */
    @Then("^\"([^\"]*)\" message should be displayed in \"([^\"]*)\" form$")
    public void messageShouldBeDisplayedInForm(String msg, SObject sObject) {
        assertion.assertTrue(Navigator.mapForm(sObject).errorNotificationText().contains(msg));
        AccountForm accountForm = new AccountForm();
        accountForm.clickCancelButton();
    }

    /**
     * Assertion step to verify the success message displayed in a Home page.
     *
     * @param msg     error message displayed.
     * @param sObject SObject enum parameter.
     */
    @Then("^\"(.*)\" message should be displayed in \"([^\"]*)\" Home Page$")
    public void messageShouldBeDisplayedInHomePage(String msg, SObject sObject) {
        final String msgExpected = helper.rebuiltMessage(msg);
        assertion.assertTrue(Navigator.mapActions(sObject).successMessageText().contains(msgExpected));
    }

    /**
     * Assertion step to verify the succes message displayed in a Detail Page.
     *
     * @param msg     error message displayed.
     * @param sObject SObject enum parameter.
     */
    @Then("^\"(.*)\" message should be displayed in \"([^\"]*)\" Detail Page$")
    public void messageShouldBeDisplayedInDetailPage(String msg, SObject sObject) {
        final String msgExpected = helper.rebuiltMessage(msg);
        assertion.assertTrue(Navigator.mapDetail(sObject).successMessageText().contains(msgExpected));
    }
}
