package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.Assertion;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityFormField;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

/**
 * Opportunity step definitions.
 */
public class OpportunityAssertionSteps {

    private Helper helper;

    private Map<OpportunityFormField, String> map;

    private Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public OpportunityAssertionSteps(Helper helper) {
        this.helper = helper;
        this.map = this.helper.getOpportunityMap();
        assertion = this.helper.getAssertion();
    }

    /**
     * The Opportunity data should be displayed on Opportunity Detail Page.
     */
    @Then("^the Opportunity should be displayed$")
    public void theOpportunityShouldBeDisplayed() {
        OpportunityDetail opportunityDetail1Detail = new OpportunityDetail();
        opportunityDetail1Detail.waitObjectNameIs(helper.getOpportunityName());
        OpportunityDetail opportunityDetail = new OpportunityDetail();
        assertion.assertTrue(opportunityDetail.getOpportunityNameText()
                .equals(map.get(OpportunityFormField.OPPORTUNITY_NAME)));
        assertion.assertTrue(opportunityDetail.getOpportunityAccountText()
                .equals(map.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));
    }

    /**
     * The Opportunity Data should be displayed on Opportunity Home Page.
     */
    @And("^the Opportunity should be displayed on Home Page$")
    public void theOpportunityShouldBeDisplayedOnHomePage() {
        OpportunityHome opportunityHome = new OpportunityHome();
        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("Opportunity"));
        CommonActions.waitFixedTime();
        assertion.assertTrue(opportunityHome.isDisplayedItem(
                map.get(OpportunityFormField.OPPORTUNITY_NAME)));
        assertion.assertTrue(opportunityHome.isOpportunityLinkDisplayed(
                map.get(OpportunityFormField.OPPORTUNITY_NAME),
                map.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));
    }

    /**
     * The Product shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Opportunity should not be displayed on Home Page$")
    public void theOpportunityShouldNotBeDisplayedOnHomePage() {
        OpportunityHome opportunityHome = new OpportunityHome();
        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("Opportunity"));
        CommonActions.waitFixedTime();
        assertion.assertFalse(opportunityHome.isDisplayedItem(
                map.get(OpportunityFormField.OPPORTUNITY_NAME)));
    }

    /**
     * This method verify if message is displayed.
     *
     * @param errorMessage is message error.
     */
    @Then("^message displayed \"([^\"]*)\"$")
    public void theOpportunityShouldBeMessageDisplayed(String errorMessage) {
        OpportunityForm opportunityForm = new OpportunityForm();
        assertion.assertTrue(opportunityForm.messageIsDisplayed(errorMessage));
    }

    /**
     * This method verify if message is displayed.
     *
     * @param error is message error.
     */
    @Then("^message displayed when field is invalid \"([^\"]*)\"$")
    public void messageDisplayedWhenFieldIsInvalid(String error) {
        OpportunityForm opportunityForm = new OpportunityForm();
        assertion.assertTrue(opportunityForm.messageFieldInvalidIsDisplayed(error));
    }
}
