Feature: Create Opportunity

  Background: Create Campaign
    Given I go to "Account" Home Page
    And I click on New "Account"
    And I fill the Account form with:
      | ACCOUNT_NAME | account |
    And I go to "Campaign" Home Page
    And I click on New "Campaign"
    And I fill the Campaign form with:
      | CAMPAIGN_NAME | campaign |
    And I go to "Opportunit" Home Page

  @bvt @deleteCampaign @deleteAccount
  Scenario: Create a new Opportunity
    When I click on New "Opportunit"
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME        | Opportunity       |
      | OPPORTUNITY_ACCOUNT     | account           |
      | DATE                    | Today             |
      | OPPORTUNITY_STAGE       | Proposal          |
      | OPPORTUNITY_TYPE        | Existing Business |
      | OPPORTUNITY_CAMPAIGN    | campaign          |
      | OPPORTUNITY_PROBABILITY | 80                |
      | OPPORTUNITY_AMOUNT      | 70                |
      | OPPORTUNITY_REASON      | Price             |
      | OPPORTUNITY_LEAD        | Advertisement     |
      | OPPORTUNITY_NEXT        | step              |
      | OPPORTUNITY_DESCRIPTION | description       |
      | BUDGE                   | true              |
      | DISCOVERY               | true              |
      | ROI                     | true              |
    Then the Opportunity should be displayed
    And I go to "Opportunit" Home Page
    And the Opportunity should be displayed on Home Page
