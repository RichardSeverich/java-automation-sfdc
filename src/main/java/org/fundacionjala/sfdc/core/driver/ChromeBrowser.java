package org.fundacionjala.sfdc.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ChromeBrowser class that implements IBrowsers.
 */
public class ChromeBrowser implements IBrowser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        return new ChromeDriver();
    }
}
