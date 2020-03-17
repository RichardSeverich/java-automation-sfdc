Feature: Edit and Delete Product

  Background:
    Given I go to "Product" Home Page
    And I click on New "Product"
    And I fill the Product form with:
      | PRODUCT_NAME | Automation |
    And I go to "Product" Home Page

  @deleteProduct @SoftAssert
  Scenario: Edit the Product on Detail Page
    When I click on the "Product" item
    And I click on Edit from Product
    And I fill the Product form with:
      | PRODUCT_NAME        | AutomationEdit        |
      | PRODUCT_CODE        | 123Edited             |
      | PRODUCT_DESCRIPTION | Just Something Edited |
      | PRODUCT_FAMILY      | None                  |
    Then "Product "${PRODUCT_NAME}" was saved." message should be displayed in "Product" Detail Page
    And the Product should be displayed
    And I go to "Product" Home Page
    And the Product should be displayed on Home Page
    And Assert all

  @deleteProduct @SoftAssert
  Scenario: Edit the Product Home Page
    When I click on Edit "Product"
    And I fill the Product form with:
      | PRODUCT_NAME        | AutomatedDemoAT04Edited |
      | PRODUCT_CODE        | 123Edited               |
      | PRODUCT_DESCRIPTION | Just Something Edited   |
      | PRODUCT_FAMILY      | None                    |
    Then "Product "${PRODUCT_NAME}" was saved." message should be displayed in "Product" Home Page
    And I go to "Product" Home Page
    And the Product should be displayed on Home Page
    And Assert all

  Scenario: Delete the Product on Home Page
    When I delete the "Product"
    Then "Product "${PRODUCT_NAME}" was deleted." message should be displayed in "Product" Home Page
    And the Product should not be displayed on Home Page

  Scenario: Delete the Product on Detail Page
    When I click on the "Product" item
    And I click on Delete from Product
    Then "Product "${PRODUCT_NAME}" was deleted." message should be displayed in "Product" Home Page
    And the Product should not be displayed on Home Page
