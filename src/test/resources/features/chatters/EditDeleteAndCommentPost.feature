Feature: Edit Post

  Background: Create Post
    Given I go to "Chatter" Home Page
    When I create a new Post with "Hi my name is Simon"

  @deletePost
  Scenario: Edit an existing Post
    When I Edit the Post with "Hi my name is Simon Ovidio Miranda Chiri"
    Then On the Chatter page should be displayed

  Scenario: Delete the Post
    When I Delete the Post
    Then On the Chatter page should not display the "Hi my name is Simon"

  @deletePost
  Scenario: Comment an existing Post
    When I comment in Post "Comment the post"
    Then On the Chatter page the comment should be displayed

  Scenario: Edit an existing Post with a invalid name 10001 characters
    When I Edit the Post with "10001" characters
    Then the message error "Review the errors on this page" should be displayed