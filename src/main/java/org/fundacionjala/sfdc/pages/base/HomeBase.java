package org.fundacionjala.sfdc.pages.base;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.SObject;

/**
 * Abstract class that gets common info in Home Page.
 */
public abstract class HomeBase extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger();

    @FindBy(xpath = "//a[@title='New']")
    protected WebElement newButton;

    protected WebElement displayedItem;

    protected WebElement dropDownListLink;

    @FindBy(xpath = "//div[contains(@class, 'visible positioned')]/descendant::a[@title='Edit']")
    protected WebElement editButton;

    @FindBy(xpath = "//div[contains(@class, 'visible positioned')]/descendant::a[@title='Delete']")
    protected WebElement deleteButton;

    @FindBy(css = "button[title='Delete']")
    protected WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@class='slds-spinner_container slds-grid slds-hide']")
    protected WebElement spinner;

    @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
    protected WebElement successMessage;

    @FindBy(xpath = "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
    protected List<WebElement> itemsList;

    /**
     * Gets the Displayed Item.
     *
     * @return WebElement displayed.
     */
    public WebElement getDisplayedItem() {
        return displayedItem;
    }

    /**
     * Determines if the Item is Displayed on the Page.
     *
     * @param name String.
     * @return Boolean.
     */
    public boolean isDisplayedItem(String name) {
        try {
            CommonActions.waitFixedTime();
            driver.navigate().refresh();
            String xpathSelector = String.format("//a[contains(text(),'%s')]", name);
            displayedItem = driver.findElement(By.xpath(xpathSelector));
            return CommonActions.isElementDisplayed(displayedItem);
        } catch (NoSuchElementException e) {
            LOGGER.error("No Such Element Exception");
            LOGGER.info(e);
            return false;
        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
    }

    /**
     * Clicks the Displayed Item.
     *
     * @param name String.
     * @return DetailBase.
     */
    public abstract DetailBase clickDisplayedItem(String name);

    /**
     * Clicks the New Button to open Form Base.
     *
     * @return FormBase.
     */
    public abstract FormBase clickNewButton();

    /**
     * Clicks the Edit Button to open Form Base.
     *
     * @param name String.
     * @return FormBase.
     */
    public abstract FormBase clickEditButton(String name);

    /**
     * Click the DropDown List of the Item.
     *
     * @param name String.
     */
    public void clickDropDownListLink(String name) {
        final String xpathSelector = String.format("//a[contains(text(),'%s')]/ancestor::tr/"
                + "descendant::a[contains(@class,'slds-button slds-button--icon-x-small')]", name);
        dropDownListLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
        dropDownListLink.click();
    }

    /**
     * Clicks the Delete Button.
     */
    public void clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
    }

    /**
     * Clicks the Confirm Delete Button.
     */
    public void clickConfirmDeleteButton() {
        CommonActions.clickElement(confirmDeleteButton);
    }

    /**
     * Clicks on a item list.
     *
     * @param name the item name.
     */
    public void clickItemList(String name) {
        DriverManager.getInstance().getDriver().navigate().refresh();
        CommonActions.clickElement(CommonActions.findWebElement(itemsList, name));
    }

    /**
     * Clicks on a item list.
     *
     * @param sObject object enum.
     * @param name the item name.
     * @return a detail base instance.
     */
    public DetailBase clickItemList(SObject sObject, String name) {
        DriverManager.getInstance().getDriver().navigate().refresh();
        CommonActions.clickElement(CommonActions.findWebElement(itemsList, name));
        return Navigator.mapDetail(sObject);
    }

    /**
     * Deletes the Element.
     *
     * @param name String.
     */
    public void deleteElement(String name) {
        clickDropDownListLink(name);
        clickDeleteButton();
        clickConfirmDeleteButton();
    }

    /**
     * Waits until the spinner is hidden.
     */
    public void waitUntilSpinnerIsHidden() {
        wait.until(ExpectedConditions.invisibilityOf(spinner));
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
