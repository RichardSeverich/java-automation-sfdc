Feature: Edit Account

  Background:
    Given I go to "Account" Home Page
    And I click on New "Account"
    When I fill the Account form with:
      | ACCOUNT_NAME | Automation |

  @deleteAccount @SoftAssert
  Scenario: Edit the Account on Detail Page
    When I click on Edit from Account
    And I fill the Account form with:
      | ACCOUNT_NAME            | AutomationEdit             |
      | ACCOUNT_TYPE            | Analyst                    |
      | ACCOUNT_WEBSITE         | www.somepage.com           |
      | ACCOUNT_DESCRIPTION     | This is a Description test |
      | ACCOUNT_PHONE           | 59179732801                |
      | ACCOUNT_INDUSTRY        | Banking                    |
      | ACCOUNT_EMPLOYEES       | 25                         |
      | ACCOUNT_BILLING_STREET  | Some Street                |
      | ACCOUNT_BILLING_CITY    | Cochabamba                 |
      | ACCOUNT_BILLING_ZIP     | 3001                       |
      | ACCOUNT_BILLING_STATE   | Cercado                    |
      | ACCOUNT_BILLING_COUNTRY | Bolivia                    |
    Then "Account "${ACCOUNT_NAME}" was saved." message should be displayed in "Account" Detail Page
    And the Account should be displayed
    And I go to "Account" Home Page
    And the Account should be displayed on Home Page
    And Assert all

  @deleteAccount @SoftAssert
  Scenario: Edit the Account on Home Page
    When I go to "Account" Home Page
    And I click on the "Account" item
    And I click on Edit from Account
    And I fill the Account form with:
      | ACCOUNT_NAME            | AutomationEdit             |
      | ACCOUNT_TYPE            | Analyst                    |
      | ACCOUNT_WEBSITE         | www.somepage.com           |
      | ACCOUNT_DESCRIPTION     | This is a Description test |
      | ACCOUNT_PHONE           | 59179732801                |
      | ACCOUNT_INDUSTRY        | Banking                    |
      | ACCOUNT_EMPLOYEES       | 25                         |
      | ACCOUNT_BILLING_STREET  | Some Street                |
      | ACCOUNT_BILLING_CITY    | Cochabamba                 |
      | ACCOUNT_BILLING_ZIP     | 3001                       |
      | ACCOUNT_BILLING_STATE   | Cercado                    |
      | ACCOUNT_BILLING_COUNTRY | Bolivia                    |
    Then "Account "${ACCOUNT_NAME}" was saved." message should be displayed in "Account" Detail Page
    And the Account should be displayed
    And I go to "Account" Home Page
    And the Account should be displayed on Home Page
    And Assert all

  Scenario: Delete the Account on Detail Page
    When I Click on Delete from Account
    Then "Account "${ACCOUNT_NAME}" was deleted." message should be displayed in "Account" Home Page
    And the Account should not be displayed on Home Page

  Scenario: Delete the Account on Home Page
    When I go to "Account" Home Page
    And I click on the "Account" item
    And I Click on Delete from Account
    Then "Account "${ACCOUNT_NAME}" was deleted." message should be displayed in "Account" Home Page
    And the Account should not be displayed on Home Page
