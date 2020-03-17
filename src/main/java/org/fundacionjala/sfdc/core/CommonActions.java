package org.fundacionjala.sfdc.core;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.driver.DriverManager;

/**
 * Class containing the common actions for the framework.
 */
public final class CommonActions {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String JS_SCRIPT = "document.querySelector(\"a[title='%s']\").click();";

    /**
     * Constructor private.
     */
    private CommonActions() {
    }

    /**
     * This method waits and clear the WebElement.
     *
     * @param webElement WebElement to wait and clear.
     */
    public static void clearTextField(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * This method set a Input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void setInputField(WebElement webElement, String text) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    /**
     * This method waits and click on the webElement.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElement(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method waits and get the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public static String getTextElement(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method verify that Web element is Displayed.
     *
     * @param webElement WebElement.
     * @return True if the element is Displayed.
     */
    public static boolean isElementDisplayed(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    /**
     * Check if the element is selected.
     *
     * @param element WebElement.
     * @return boolean.
     */
    public static boolean isElementSelected(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        return element.isSelected();
    }

    /**
     * Set Check Box status.
     *
     * @param element WebElement.
     * @param flag    boolean.
     */
    public static void setCheckBox(WebElement element, boolean flag) {
        if (!isElementSelected(element) && flag) {
            clickElement(element);
        }
    }

    /**
     * This method generates a wait for a fixed time, uses the driver manager to generate
     * a explicit wait for a web element that does not exist.
     */
    public static void waitFixedTime() {
        try {
            DriverManager.getInstance().setUpdateWait(2);
            DriverManager.getInstance().getWait()
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Just For Wait']")));
        } catch (TimeoutException e) {
            LOGGER.error("Timeout exception triggered");
            LOGGER.info(e);
        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
    }

    /**
     * This method perform a search in a WebElement list based on a content string parameter.
     *
     * @param elements is the WebElements lists.
     * @param content  is the content parameter.
     * @return the WebElement search result.
     */
    public static WebElement findWebElement(List<WebElement> elements, String content) {
        return elements.stream()
                .filter(element -> content.contains(element.getText()))
                .findAny()
                .orElse(null);
    }

    /**
     * This method perform a click in a non visible element in the UI using css locator.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public static void jsClickCssButton(WebElement webElement) {
        ((JavascriptExecutor) DriverManager.getInstance().getDriver())
                .executeScript(String.format(JS_SCRIPT, webElement.getAttribute("title")));
    }

    /**
     * This method perform a click in a non visible element in the UI using class locator.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public static void jsClickClassButton(WebElement webElement) {
        ((JavascriptExecutor) DriverManager.getInstance().getDriver())
                .executeScript("arguments[0].click();", webElement);
    }
}
