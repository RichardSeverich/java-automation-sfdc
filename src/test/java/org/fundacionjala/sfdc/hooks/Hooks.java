package org.fundacionjala.sfdc.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.SObject;

/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    private Helper helper;

    /**
     * Default Constructor.
     *
     * @param helper Helper.
     */
    public Hooks(Helper helper) {
        this.helper = helper;
    }

    /**
     * Delete Product.
     */
    @After(value = "@deleteProduct", order = 10)
    public void deleteCreatedItem() {
        Navigator.goToProductsHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Post.
     */
    @After(value = "@deletePost", order = 10)
    public void deleteCreatedIPost() {
        Navigator.goToChatterHome().deletePost(helper.getPostMessage());
    }

    /**
     * Delete Account.
     */
    @After(value = "@deleteAccount", order = 5)
    public void deleteCreatedAccount() {
        Navigator.goToAccountsHome().clickItemList(SObject.ACCOUNT, helper.getItemName()).deleteItem();
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign", order = 7)
    public void deleteCreatedItemCampaign() {
        Navigator.goToCampaignHome().clickItemList(SObject.CAMPAIGN, helper.getCampaignName()).deleteItem();
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Set a instance of Soft Assert to helper.
     */
    @Before(value = "@SoftAssert", order = 10)
    public void setSoftAssertion() {
        helper.setAssertion(new SoftAssert());
    }

    /**
     * Set a instance of Hard Assert to helper.
     */
    @Before(order = 1)
    public void setHardAssertion() {
        helper.setAssertion(new Assertion());
    }


    /**
     * wait two seconds.
     */
    @Before(order = 15)
    public void waitBefore() {
        CommonActions.waitFixedTime();
    }

}
