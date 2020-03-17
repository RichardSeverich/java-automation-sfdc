package org.fundacionjala.sfdc.core.driver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.fundacionjala.sfdc.core.Env;

/**
 * SauceLabs class that implements IBrowsers.
 */
public class SauceLabs extends CloudBrowser implements IBrowser {
    private static final Env ENV = Env.getInstance();

    private static final String USERNAME = ENV.getRemoteUserName();
    private static final String ACCESS_KEY = ENV.getRemoteKey();
    private static final String URL =
            String.format("https://%s:%s@ondemand.saucelabs.com:443/wd/hub", USERNAME, ACCESS_KEY);
    private static final String PLATFORM = "platform";
    private static final String RESOLUTION = "resolution";

    /**
     * This is the constructor.
     */
    SauceLabs() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, ENV.getRemoteBrowser());
        caps.setCapability(CapabilityType.VERSION, ENV.getRemoteBrowserVersion());
        caps.setCapability(PLATFORM, String.format("%s %s",
                ENV.getRemotePlatform(),
                ENV.getRemotePlatformVersion()));
        caps.setCapability(RESOLUTION, ENV.getRemoteResolution());
        return caps;
    }
}
