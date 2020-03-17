package org.fundacionjala.sfdc.pages;

import java.util.EnumMap;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.acccounts.AccountDetail;
import org.fundacionjala.sfdc.pages.acccounts.AccountForm;
import org.fundacionjala.sfdc.pages.acccounts.AccountHome;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignHome;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Final class Navigator to access the different pages.
 */
public final class Navigator {

    /**
     * Private Constructor.
     */
    private Navigator() {

    }

    /**
     * Click and returns an AppLauncher Instance.
     *
     * @return AppLauncher.
     */
    public static AppLauncher clickAppLauncher() {
        return new Home().clickAppLauncher();
    }

    /**
     * Go to Products Home Page.
     *
     * @return ProductHome.
     */
    public static ProductHome goToProductsHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Product")) {
            clickAppLauncher().clickProductsTextLink();
        }
        return new ProductHome();
    }

    /**
     * Go to Chatter Home Page.
     *
     * @return PostForm.
     */
    public static PostForm goToChatterHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("chatter")) {
            clickAppLauncher().clickChatterTextLink();
        }
        return new PostForm();
    }

    /**
     * Go to Opportunity Home Page.
     *
     * @return OpportunityHome.
     */
    public static OpportunityHome goToOpportunityHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Opportunity")) {
            clickAppLauncher().clickOpportunityTextLink();
        }
        return new OpportunityHome();
    }

    /**
     * Go to Campaign Home Page.
     *
     * @return CampaignHome.
     */
    public static CampaignHome goToCampaignHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Campaign")) {
            clickAppLauncher().clickCampaignTextLink();
        }
        return new CampaignHome();
    }

    /**
     * Static method to go to any page on Enum SObject.
     *
     * @param endPoint SObject.
     * @return HomeBase.
     */
    public static BasePage gotoPage(SObject endPoint) {
        switch (endPoint) {
            case ACCOUNT:
                return goToAccountsHome();
            case CHATTER:
                return goToChatterHome();
            case OPPORTUNIT:
                return goToOpportunityHome();
            case CAMPAIGN:
                return goToCampaignHome();
            default:
                return goToProductsHome();
        }
    }

    /**
     * Go to Accounts Home Page.
     *
     * @return ProductHome.
     */
    public static AccountHome goToAccountsHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Account")) {
            clickAppLauncher().clickAccountTextLink();
        }
        return new AccountHome();
    }

    /**
     * Static method to map Actions.
     *
     * @param item SObject.
     * @return HomeBase.
     */
    public static HomeBase mapActions(SObject item) {
        CommonActions.waitFixedTime();
        EnumMap<SObject, HomeBase> map = new EnumMap<>(SObject.class);
        map.put(SObject.PRODUCT, new ProductHome());
        map.put(SObject.ACCOUNT, new AccountHome());
        map.put(SObject.OPPORTUNIT, new OpportunityHome());
        map.put(SObject.CAMPAIGN, new CampaignHome());
        return map.get(item);
    }

    /**
     * Static method to return a specific Form page.
     *
     * @param item SObject.
     * @return FormBase.
     */
    public static FormBase mapForm(SObject item) {
        EnumMap<SObject, FormBase> map = new EnumMap<>(SObject.class);
        map.put(SObject.PRODUCT, new ProductForm());
        map.put(SObject.ACCOUNT, new AccountForm());
        map.put(SObject.OPPORTUNIT, new OpportunityForm());
        map.put(SObject.CAMPAIGN, new CampaignForm());
        return map.get(item);
    }

    /**
     * Static method to return a specific Detail page.
     *
     * @param item SObject.
     * @return DetailBase.
     */
    public static DetailBase mapDetail(SObject item) {
        EnumMap<SObject, DetailBase> map = new EnumMap<>(SObject.class);
        map.put(SObject.PRODUCT, new ProductDetail());
        map.put(SObject.ACCOUNT, new AccountDetail());
        map.put(SObject.OPPORTUNIT, new OpportunityDetail());
        map.put(SObject.CAMPAIGN, new CampaignDetail());
        return map.get(item);
    }
}
