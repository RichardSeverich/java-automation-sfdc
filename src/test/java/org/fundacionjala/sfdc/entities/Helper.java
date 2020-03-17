package org.fundacionjala.sfdc.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import org.testng.asserts.Assertion;

import org.fundacionjala.sfdc.pages.acccounts.AccountFormField;
import org.fundacionjala.sfdc.pages.campaigns.CampaignFormField;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityFormField;
import org.fundacionjala.sfdc.pages.products.ProductFormField;

/**
 * Helper class with Dependency Injection for all Steps.
 */
public class Helper {

    private String itemName = "";

    private String postMessage = "";

    private String commentPostMessage = "";

    private String campaignName = "";

    private String opportunityName = "";

    private Assertion assertion;

    private Map<AccountFormField, String> accountMap;

    private Map<CampaignFormField, String> campaignMap;

    private Map<OpportunityFormField, String> opportunityMap;

    private Map<ProductFormField, String> productMap;

    private static final String REGEX_QUOTES_INSIDE = "(?<=\")(.*?)(?=\")";

    /**
     * Get the Item Name for edit and delete purposes.
     *
     * @return String.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the Item Name value.
     *
     * @param itemName String.
     */
    public void setItemName(String itemName) {
        this.itemName = concatPrefixSuffix(itemName);
    }

    /**
     * Get Post Message.
     *
     * @return String.
     */
    public String getPostMessage() {
        return postMessage;
    }

    /**
     * Set Post Message.
     *
     * @param postMessage String.
     */
    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    /**
     * Get Comment Post Message.
     *
     * @return String.
     */
    public String getCommentPostMessage() {
        return commentPostMessage;
    }

    /**
     * Set Comment Post Message.
     *
     * @param commentPostMessage String.
     */
    public void setCommentPostMessage(String commentPostMessage) {
        this.commentPostMessage = concatPrefixSuffix(commentPostMessage);
    }

    /**
     * Get Campaign Name.
     *
     * @return String.
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Set Account Name.
     *
     * @param campaignName String.
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = concatPrefixSuffix(campaignName);
    }

    /**
     * Get Opportunity Name.
     *
     * @return String.
     */
    public String getOpportunityName() {
        return opportunityName;
    }

    /**
     * Set Opportunity Name.
     *
     * @param opportunityName String.
     */
    public void setOpportunityName(String opportunityName) {
        this.opportunityName = concatPrefixSuffix(opportunityName);
    }

    /**
     * Get Assertion.
     *
     * @return a instance of Assertion.
     */
    public Assertion getAssertion() {
        return assertion;
    }

    /**
     * Set assertion instance.
     *
     * @param assertion a instance of Soft Assertion.
     */
    public void setAssertion(Assertion assertion) {
        this.assertion = assertion;
    }

    /**
     * Get the account map.
     *
     * @return the account map object.
     */
    public Map<AccountFormField, String> getAccountMap() {
        return accountMap;
    }

    /**
     * Set the account map.
     *
     * @param accountMap is the account map.
     */
    public void setAccountMap(Map<AccountFormField, String> accountMap) {
        this.accountMap = new EnumMap<>(accountMap);
        this.accountMap.replace(AccountFormField.ACCOUNT_NAME, getItemName());
    }

    /**
     * Get the campaign map.
     *
     * @return the campaign map object.
     */
    public Map<CampaignFormField, String> getCampaignMap() {
        return campaignMap;
    }

    /**
     * Set the campaign map.
     *
     * @param campaignMap is the campaign map.
     */
    public void setCampaignMap(Map<CampaignFormField, String> campaignMap) {
        this.campaignMap = new EnumMap<>(campaignMap);
        this.campaignMap.replace(CampaignFormField.CAMPAIGN_NAME, getCampaignName());
    }

    /**
     * Get the opportunity map.
     *
     * @return the opportunity map object.
     */
    public Map<OpportunityFormField, String> getOpportunityMap() {
        return opportunityMap;
    }

    /**
     * Set the opportunity map.
     *
     * @param opportunityMap is the opportunity map.
     */
    public void setOpportunityMap(Map<OpportunityFormField, String> opportunityMap) {
        this.opportunityMap = new EnumMap<>(opportunityMap);
        this.opportunityMap.replace(OpportunityFormField.OPPORTUNITY_NAME, getOpportunityName());
        this.opportunityMap.replace(OpportunityFormField.OPPORTUNITY_CAMPAIGN, getCampaignName());
        this.opportunityMap.replace(OpportunityFormField.OPPORTUNITY_ACCOUNT, getItemName());
    }

    /**
     * Get the product map.
     *
     * @return the product map object.
     */
    public Map<ProductFormField, String> getProductMap() {
        return productMap;
    }

    /**
     * Set the product map.
     *
     * @param productMap is the product map.
     */
    public void setProductMap(Map<ProductFormField, String> productMap) {
        this.productMap = new EnumMap<>(productMap);
        this.productMap.replace(ProductFormField.PRODUCT_NAME, getItemName());
    }

    /**
     * Rebuilt an asertion message, replacing the item string value in the message.
     *
     * @param msg expected message.
     * @return the rebuilt message.
     */
    public String rebuiltMessage(String msg) {
        return msg.replaceAll(REGEX_QUOTES_INSIDE, getItemName());
    }

    /**
     * Concat a specified prefix (AT-04) and a unix timestamp suffix (in HEX representation).
     *
     * @param name the original parameter name.
     * @return the concat result.
     */
    private String concatPrefixSuffix(String name) {
        final Date date = Calendar.getInstance().getTime();
        return name.isEmpty() ? name : String.format("%s%s%s", "AT-04", name, Long.toHexString(date.getTime()));
    }
}
