package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.Then;
import org.testng.asserts.Assertion;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Chatter assert step definitions.
 */
public class ChatterAssertionSteps {

    private Helper helper;

    private Assertion assertion;

    private PostForm postForm;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ChatterAssertionSteps(Helper helper) {
        this.helper = helper;
        this.assertion = helper.getAssertion();
        postForm = new PostForm();
    }

    /**
     * The post edited should be displayed.
     *
     * @param message String.
     */
    @Then("^On the Chatter page should not display the \"([^\"]*)\"$")
    public void onTheChatterPageShouldNotDisplayThe(String message) {
        assertion.assertFalse(postForm.isPostDisplayed(message));
    }

    /**
     * The comment for the Post should be displayed.
     */
    @Then("^On the Chatter page the comment should be displayed$")
    public void onTheChatterPageTheCommentShouldBeDisplayed() {
        assertion.assertTrue(postForm.isPostDisplayed(helper.getCommentPostMessage()));
    }

    /**
     * The Chatter page should be displayed.
     */
    @Then("^On the Chatter page should be displayed$")
    public void onTheChatterPageShouldBeDisplayed() {
        assertion.assertTrue(postForm.isPostDisplayed(helper.getPostMessage()));
    }

    /**
     * The Error message should be displayed.
     *
     * @param errorMessage this variable contains the error message.
     */
    @Then("^the message error \"([^\"]*)\" should be displayed$")
    public void onTheChatterPageTheMessageErrorShouldBeDisplayed(String errorMessage) {
        assertion.assertTrue(postForm.isVisibleErrorMessage(errorMessage));

    }
}
