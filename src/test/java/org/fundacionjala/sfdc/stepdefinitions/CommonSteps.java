package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.SObject;

/**
 * Common Steps for all features.
 */
public class CommonSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CommonSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Step to go to Item Home Page.
     *
     * @param sObject SObject.
     */
    @Given("^I go to \"([^\"]*)\" Home Page$")
    public void iGoToHomePage(SObject sObject) {
        DriverManager.getInstance().getDriver().navigate().refresh();
        CommonActions.waitFixedTime();
        Navigator.gotoPage(sObject);
    }

    /**
     * Step to click on New Button.
     *
     * @param sObject SObject.
     */
    @And("^I click on New \"([^\"]*)\"$")
    public void iClickOnNew(SObject sObject) {
        CommonActions.waitFixedTime();
        Navigator.mapActions(sObject).clickNewButton();
    }

    /**
     * Click on Edit Button.
     *
     * @param sObject SObject.
     */
    @When("^I click on Edit \"([^\"]*)\"$")
    public void iClickOnEdit(SObject sObject) {
        Navigator.mapActions(sObject).clickEditButton(helper.getItemName());
    }

    /**
     * Delete the selected Object.
     *
     * @param sObject SObject.
     */
    @And("^I delete the \"([^\"]*)\"$")
    public void iDeleteThe(SObject sObject) {
        Navigator.mapActions(sObject).deleteElement(helper.getItemName());
    }

    /**
     * Click on a specified item of the list.
     *
     * @param sObject SObject.
     */
    @And("^I click on the \"([^\"]*)\" item$")
    public void iClickOnTheItem(SObject sObject) {
        Navigator.mapActions(sObject).clickItemList(helper.getItemName());
    }

    /**
     * This method refresh page.
     */
    @And("^refresh page$")
    public void refreshPage() {
        DriverManager.getInstance().getDriver().navigate().refresh();
        CommonActions.waitFixedTime();
    }
}
