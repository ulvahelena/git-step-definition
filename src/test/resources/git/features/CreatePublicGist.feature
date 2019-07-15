@create-public-gist
Feature: Create Public Gist
  As a user I can create public gist

  @git @create-public-gist
  Scenario: user can create public gist
    Given user navigate to git page
    When user login to Git using USER account
    And user click button "akun"
    And user click button "your gists"
    And user click button "create a gist"
    And user type gist description
    And user type gist file name
    And user type gist content
    And user click button "create public gist"
    Then user should be redirect to new gist page