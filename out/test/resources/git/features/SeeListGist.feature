@see-existing-gist
Feature: See Existing Gist
  As a user I can see existing gist

  @git @see-existing-gist
  Scenario: user can see public gist
    Given user navigate to git page
    Then user login to Git using USER account
    And user click button "akun"
    And user click button "your gists"
    Then user should redirect to list of gists