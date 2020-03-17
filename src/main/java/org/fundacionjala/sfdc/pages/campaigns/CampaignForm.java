package org.fundacionjala.sfdc.pages.campaigns;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.IStrategySteps;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * Class containing Campaign Form Page.
 */
public class CampaignForm extends FormBase {

    @FindBy(xpath = "//span[contains(text(), 'Campaign Name')]/parent::label/following-sibling::input")
    private WebElement campaignNameInputText;

    /**
     * Set the campaign Name.
     *
     * @param campaignName String.
     */
    private void setCampaignNameInputText(String campaignName) {
        if (CommonActions.isElementDisplayed(campaignNameInputText)) {
            CommonActions.setInputField(campaignNameInputText, campaignName);
        }
    }

    /**
     * {@inheritDoc}
     */
    public CampaignDetail fillAndSaveForm(Map<CampaignFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new CampaignDetail();
    }

    /**
     * Get the Strategy map.
     *
     * @param formMap Map.
     * @return Map.
     */
    private Map<CampaignFormField, IStrategySteps> getStrategyMap(Map<CampaignFormField, String> formMap) {
        EnumMap<CampaignFormField, IStrategySteps> strategyMap = new EnumMap<>(CampaignFormField.class);
        strategyMap.put(CampaignFormField.CAMPAIGN_NAME,
                () -> setCampaignNameInputText(formMap.get(CampaignFormField.CAMPAIGN_NAME)));
        return strategyMap;
    }
}
