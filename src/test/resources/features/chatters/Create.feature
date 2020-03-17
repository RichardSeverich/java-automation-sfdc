Feature: Create Post

  Background: Create Post
    Given I go to "Chatter" Home Page

  @deletePost @bvt
  Scenario: Create a new Post
    When I create a new Post with "Hi my name is Simon"
    Then On the Chatter page should be displayed

  Scenario: Verify that the user can not create a new Post with more than 10000 characters.
    When I set post with "10001" characters
    Then the message error "Review the errors on this page" should be displayed