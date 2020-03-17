Feature: Negative Testing

  Background:
    Given I go to "Opportunit" Home Page
    And I click on New "Opportunit"

  Scenario: I can't create a new Opportunity without fields required.
    When I fill the Opportunity form with:
      | OPPORTUNITY_NAME |  |
    Then message displayed "These required fields must be completed: Account Name, Close Date, Opportunity Name, Stage"
