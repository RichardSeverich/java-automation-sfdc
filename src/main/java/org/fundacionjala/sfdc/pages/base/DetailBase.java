package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;

/**
 * Abstract class that gets common info in Details Page.
 */
public abstract class DetailBase extends BasePage {

    @FindBy(css = "a[title='Edit']")
    protected WebElement editButton;

    @FindBy(css = "div[title='Delete']")
    protected WebElement deleteButton;

    @FindBy(css = "button[title='Delete']")
    protected WebElement confirmDeleteButton;

    @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
    protected WebElement successMessage;

    /**
     * Wait the Product Name is Displayed.
     *
     * @param name String.
     */
    public void waitObjectNameIs(String name) {
        String cssSelector = String.format("h1[title='%s']", name);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    /**
     * Opens the Form page for editing.
     *
     * @return FormBase.
     */
    public abstract FormBase clickEditButton();

    /**
     * Click the delete button of the current Item.
     */
    public void clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
    }

    /**
     * Click the Confirm Delete Button from the current Item.
     */
    public void clickConfirmDeleteButton() {
        CommonActions.clickElement(confirmDeleteButton);
    }

    /**
     * Deletes the current Item.
     *
     * @return HomeBase.
     */
    public abstract HomeBase deleteItem();

    /**
     * Wait for the success message to be visible.
     */
    public void waitUntilSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    /**
     * Return the success text message.
     *
     * @return the success message content.
     */
    public String successMessageText() {
        return CommonActions.getTextElement(successMessage);
    }
}
