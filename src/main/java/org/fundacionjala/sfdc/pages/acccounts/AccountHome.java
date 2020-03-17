package org.fundacionjala.sfdc.pages.acccounts;

import org.openqa.selenium.By;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Class containing Account Home Page.
 */
public class AccountHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDetail clickDisplayedItem(String name) {
        isDisplayedItem(name);
        displayedItem.click();
        return new AccountDetail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickNewButton() {
        CommonActions.jsClickCssButton(newButton);
        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.jsClickCssButton(editButton);
        return new AccountForm();
    }

    /**
     * Determines if the Account Field Data is displayed on Home Page.
     *
     * @param accountName  Account Name for row.
     * @param accountField Account Fields .
     * @return boolean.
     */
    public boolean isAccountFieldDisplayed(String accountName, String accountField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                accountName, accountField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
