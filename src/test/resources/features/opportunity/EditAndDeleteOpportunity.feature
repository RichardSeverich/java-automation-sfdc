Feature: Edit Opportunity

  Background:
    Given I go to "Account" Home Page
    And I click on New "Account"
    And I fill the Account form with:
      | ACCOUNT_NAME | account |
    And I go to "Campaign" Home Page
    And I click on New "Campaign"
    And I fill the Campaign form with:
      | CAMPAIGN_NAME | campaign |
    And I go to "Opportunit" Home Page
    And I click on New "Opportunit"
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME     | Opportunity      |
      | OPPORTUNITY_ACCOUNT  | ${ACCOUNT_NAME}  |
      | DATE                 | 13/08/2017       |
      | OPPORTUNITY_STAGE    | Proposal         |
      | OPPORTUNITY_CAMPAIGN | ${CAMPAIGN_NAME} |

  @deleteAccount @deleteCampaign
  Scenario: Edit the Opportunity on Detail Page
    When I click on Edit Opportunity
    And I fill the Opportunity form with:
      | OPPORTUNITY_NAME        | OpportunityEdit   |
      | DATE                    | Today             |
      | OPPORTUNITY_TYPE        | Existing Business |
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

  @deleteAccount @deleteCampaign
  Scenario: Delete the Opportunity on Detail Page
    When I Click on Delete from Opportunity
    Then the Opportunity should not be displayed on Home Page
