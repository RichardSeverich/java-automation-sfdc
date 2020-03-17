package org.fundacionjala.sfdc.core.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.fundacionjala.sfdc.core.Env;

/**
 * BrowserStack class that implements IBrowsers.
 */
public class BrowserStack extends CloudBrowser implements IBrowser {

    private static final Env ENV = Env.getInstance();

    private static final String USER_NAME = ENV.getRemoteUserName();
    private static final String ACCESS_KEY = ENV.getRemoteKey();
    private static final String URL =
            String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", USER_NAME, ACCESS_KEY);
    private static final String BROWSER = "browser";
    private static final String VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";
    private static final String RESOLUTION = "resolution";

    /**
     * This is the constructor.
     */
    BrowserStack() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER, ENV.getRemoteBrowser());
        caps.setCapability(VERSION, ENV.getRemoteBrowserVersion());
        caps.setCapability(OS, ENV.getRemotePlatform());
        caps.setCapability(OS_VERSION, ENV.getRemotePlatformVersion());
        caps.setCapability(RESOLUTION, ENV.getRemoteResolution());
        return caps;
    }
}
