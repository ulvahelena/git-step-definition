@delete-existing-gist
Feature: Delete Existing Gist
  As a user I can delete existing gist

  @git @delete-existing-gist
  Scenario: user can delete public gist
    Given user navigate to git page
    Then user login to Git using USER account
    And user click button "akun"
    And user click button "your gists"
    And user click on list gists
    And user click button "Delete"
    Then user click button "OK"