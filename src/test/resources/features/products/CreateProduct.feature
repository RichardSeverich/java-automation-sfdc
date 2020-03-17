Feature: Create Product

  @bvt @deleteProduct @SoftAssert
  Scenario: Create a new Product
    Given I go to "Product" Home Page
    And I click on New "Product"
    When I fill the Product form with:
      | PRODUCT_NAME        | Automation     |
      | PRODUCT_CODE        | 123            |
      | PRODUCT_DESCRIPTION | Just Something |
      | PRODUCT_FAMILY      | None           |
      | ACTIVE              | true           |
    Then "Product "${PRODUCT_NAME}" was created." message should be displayed in "Product" Detail Page
    Then the Product should be displayed
    And I go to "Product" Home Page
    And the Product should be displayed on Home Page
    And Assert all

  Scenario: Create a new Product with empty name
    Given I go to "Product" Home Page
    And I click on New "Product"
    When I fill the Product form with:
      | PRODUCT_NAME |  |
    Then "These required fields must be completed: Product Name" message should be displayed in "Product" form
