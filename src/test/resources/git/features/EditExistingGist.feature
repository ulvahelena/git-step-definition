@edit-existing-gist
Feature: Edit Existing Gist
  As a user I can edit existing gist

  @git @cedit-existing-gist
  Scenario: user can create public gist
    Given user navigate to git page
    Then user login to Git using USER account
    And user click button "akun"
    And user click button "your gists"
    And user click on list gists
    And user click button "Edit"
    And user edit gist description
    And user click button "Update public gist"
    Then user should be redirect to update gist page