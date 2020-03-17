package org.fundacionjala.sfdc.core.driver;

import org.openqa.selenium.WebDriver;

/**
 * Interface for getting the current browser.
 */
@FunctionalInterface
public interface IBrowser {

    /**
     * Gets the WebDriver to use.
     *
     * @return WebDriver.
     */
    WebDriver getBrowser();
}
