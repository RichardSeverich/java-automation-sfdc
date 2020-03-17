package org.fundacionjala.sfdc.pages.chatter;

import java.util.Collections;
import java.util.EnumMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.BasePage;

/**
 * Class for the Post Form page for Chatter.
 */
public class PostForm extends BasePage {

    private static final String ACTION_MENU = "cuf-feedItemActionTrigger";

    private static final String ACTION_COMMENT = "cuf-commentTrigger";

    private static final String ACTION_LIKE = "like-target";

    private static final String ACTION_UNLIKE = "unlike-target";

    private static final String ACTION_SHARED = "shareMenuTrigger";

    private static final Logger LOGGER = LogManager.getLogger();

    @FindBy(xpath = "//span[text()='Post']")
    private WebElement clickPostTabBar;

    @FindBy(css = ".dummyControlsContainer .slds-button--neutral.uiButton")
    private WebElement sectionPostTextAreaField;

    @FindBy(css = ".slds-rich-text-area__content")
    private WebElement postTextAreaField;

    @FindBy(css = ".cuf-publisherShareButton")
    private WebElement shareButton;

    @FindBy(css = "a[title='Edit']")
    private WebElement postOptionEditButton;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement postOptionDeleteButton;

    @FindBy(xpath = "//button[@title  ='Delete']")
    private WebElement confirmDeleteButton;

    @FindBy(css = "div[data-placeholder='Update your post...']")
    private WebElement editTextAreaField;

    @FindBy(xpath = "//div[contains(@class, 'modal-footer')]/descendant::span[text()='Save']")
    private WebElement saveEditButton;

    @FindBy(css = "div[data-placeholder='Write a comment...']")
    private WebElement commentTextAreaField;

    @FindBy(xpath = "//span[text()='Comment']")
    private WebElement confirmCommentButton;

    @FindBy(css = ".cuf-publisherAttachmentButton")
    private WebElement attachmentIcon;

    @FindBy(css = ".forceModalSpinner.hideEl")
    private WebElement spinner;

    //Error message
    @FindBy(css = "div[class='desktop  forcePageError'] span[class='genericError uiOutputText']")
    private WebElement errorMessage;

    /**
     * Click On Post Text Area Field.
     */
    public void clickOnPostTextAreaField() {
        CommonActions.clickElement(sectionPostTextAreaField);
    }

    /**
     * Set Text for Post.
     *
     * @param postText text.
     * @return PostForm pageObject.
     */
    public PostForm setTextPost(String postText) {
        clickOnPostTextAreaField();
        CommonActions.setInputField(postTextAreaField, postText);
        return this;
    }

    /**
     * Click Share for Save Post.
     */
    public void clickShareforSavePost() {
        CommonActions.clickElement(shareButton);
    }

    /**
     * Click Post To Delete.
     */
    public void clickPostToDelete() {
        CommonActions.clickElement(postOptionDeleteButton);
    }

    /**
     * Click On Confirm To Delete The Post.
     */
    public void clickOnConfirmToDeleteThePost() {
        CommonActions.clickElement(confirmDeleteButton);
    }


    /**
     * Click Post To Edit.
     */
    public void clickPostToEdit() {
        CommonActions.clickElement(postOptionEditButton);
    }


    /**
     * Click On Edit Text Area Field.
     */
    public void clickOnEditTextAreaField() {
        CommonActions.clickElement(editTextAreaField);

    }

    /**
     * Set Edit TextArea Field.
     *
     * @param messageEdited String.
     */
    public void setEditTextAreaField(String messageEdited) {
        clickOnEditTextAreaField();
        CommonActions.setInputField(editTextAreaField, messageEdited);
    }

    /**
     * Click Save Edition.
     */
    public void clickSaveEdition() {
        CommonActions.clickElement(saveEditButton);
    }

    /**
     * Set Comment.
     *
     * @param commentText String.
     */
    public void setComment(String commentText) {
        CommonActions.setInputField(commentTextAreaField, commentText);
    }

    /**
     * Click Save Comment.
     */
    public void clickSaveComment() {
        CommonActions.clickElement(confirmCommentButton);
    }

    /**
     * Concat Xpath for Action.
     *
     * @param messagePost messagePost.
     * @param action      action.
     * @return string concat.
     */
    public String concatXpath(String messagePost, String action) {
        String selectorOfPost = String.format("//span[contains(text(),'%s')]", messagePost);
        String clickAction = String.format("/ancestor::article/descendant::a[contains(@class,'%s')]", action);
        return selectorOfPost.concat(clickAction);
    }

    /**
     * Generate Xpath.
     *
     * @param chatterActions action.
     * @param messagePost    message.
     * @return xpath final.
     */
    public String generateXpath(ChatterActions chatterActions, String messagePost) {
        EnumMap<ChatterActions, String> actionMap = new EnumMap<>(ChatterActions.class);
        actionMap.put(ChatterActions.MENU, concatXpath(messagePost, ACTION_MENU));
        actionMap.put(ChatterActions.COMMENT, concatXpath(messagePost, ACTION_COMMENT));
        actionMap.put(ChatterActions.LIKE, concatXpath(messagePost, ACTION_LIKE));
        actionMap.put(ChatterActions.UNLIKE, concatXpath(messagePost, ACTION_UNLIKE));
        actionMap.put(ChatterActions.SHARED, concatXpath(messagePost, ACTION_SHARED));
        return actionMap.get(chatterActions);
    }

    /**
     * Click Action on Post.
     *
     * @param chatterActions enum.
     * @param messagePost    String.
     */
    public void clickActionOnPost(ChatterActions chatterActions, String messagePost) {
        WebElement webElement = driver.findElement(By.xpath(generateXpath(chatterActions, messagePost)));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method verify that Web element is Displayed.
     *
     * @param postText String.
     * @return boolean.
     */
    public boolean isPostDisplayed(String postText) {
        try {
            String selector = String.format("//span[contains(text(),'%s')]", postText);
            WebElement webElement = driver.findElement(By.xpath(selector));
            return webElement.isDisplayed();

        } catch (WebDriverException e) {
            LOGGER.error("WebDriverException");
            LOGGER.info(e);
            return false;
        }
    }

    /**
     * Is Element Present.
     *
     * @param webElement webElement.
     * @return boolean.
     */
    public static boolean isElementPresent(WebElement webElement) {
        try {
            CommonActions.getTextElement(webElement);
            return true;
        } catch (WebDriverException e) {
            LOGGER.error("WebDriverException");
            LOGGER.info(e);
            return false;
        }
    }

    /**
     * Save Post.
     *
     * @param postText String.
     */
    public void savePost(String postText) {
        setTextPost(postText);
        clickShareforSavePost();
    }

    /**
     * Delete Post.
     *
     * @param postText String.
     */
    public void deletePost(String postText) {
        clickActionOnPost(ChatterActions.MENU, postText);
        clickPostToDelete();
        clickOnConfirmToDeleteThePost();
    }

    /**
     * Edit Post.
     *
     * @param postText String.
     * @param postEdit String.
     */
    public void editPost(String postText, String postEdit) {
        clickActionOnPost(ChatterActions.MENU, postText);
        clickPostToEdit();
        setEditTextAreaField(postEdit);
        clickSaveEdition();
    }

    /**
     * Comment Post.
     *
     * @param postText       String.
     * @param commentForPost String.
     */
    public void commentPost(String postText, String commentForPost) {
        clickActionOnPost(ChatterActions.COMMENT, postText);
        setComment(commentForPost);
        clickSaveComment();
    }

    /**
     * This method return true if the error message is visible.
     *
     * @param errorMessage this variable contains the error message.
     * @return true if the error message is visible.
     */
    public Boolean isVisibleErrorMessage(String errorMessage) {
        return this.errorMessage.getText().contains(errorMessage);
    }

    /**
     * This method generate post message whit defined number of characters.
     *
     * @param number this variable contains the number of characters.
     * @return pot message.
     */
    public String generatePostMessage(String number) {
        return String.join("", Collections.nCopies(Integer.parseInt(number), "a"));
    }

}
