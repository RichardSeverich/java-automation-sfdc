package org.fundacionjala.sfdc.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.fundacionjala.sfdc.core.Env;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.login.Login;

/**
 * Runner class for all tests.
 */
@CucumberOptions(
        monochrome = true,
        format = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"},
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.sfdc"})
public class Runner extends AbstractTestNGCucumberTests {

    private static final Env ENV = Env.getInstance();

    /**
     * Opens the browser and log in to Sales Force.
     */
    @BeforeTest()
    public void loginToSalesForce() {
        Login.loginInitial(ENV.getUsername(), ENV.getPassword());
    }

    /**
     * Close the browser.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().quitDriver();
    }
}
