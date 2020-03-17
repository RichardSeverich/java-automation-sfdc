package org.fundacionjala.sfdc.core.driver;

import java.util.EnumMap;

import org.openqa.selenium.WebDriver;

/**
 * Driver Factory class that gets the browser.
 */
public final class DriverFactory {

    /**
     * Private Constructor.
     */
    private DriverFactory() {

    }

    /**
     * Return current Driver.
     *
     * @param driverType Enum from DriverType.
     * @return Current WebDriver.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        EnumMap<DriverType, IBrowser> map = new EnumMap<>(DriverType.class);
        map.put(DriverType.CHROME, new ChromeBrowser());
        map.put(DriverType.FIREFOX, new FirefoxBrowser());
        map.put(DriverType.SAUCELABS, new SauceLabs());
        map.put(DriverType.BROWSERSTACK, new BrowserStack());
        map.put(DriverType.DOCKER_CHROME, new DockerChromeBrowser());
        map.put(DriverType.DOCKER_FIREFOX, new DockerFirefoxBrowser());
        return map.get(driverType).getBrowser();
    }
}
