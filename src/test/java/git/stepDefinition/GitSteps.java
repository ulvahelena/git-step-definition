package git.stepDefinition;

import cucumber.api.java8.En;
import git.pageObject.GitStepsPage;


public class GitSteps implements En {

    public GitSteps() {
        Given("^user login to Git using USER account$", () -> {
            GitStepsPage.loginToGit();
        });

        Given("^user navigate to git page$", () -> {
            GitStepsPage.navigateToGitPage();
        });

        When("^user click button \"([^\"]*)\"$", (String buttonName) -> {
            GitStepsPage.clickButton(buttonName);
        });

        And("^user type gist description$", () -> {
            GitStepsPage.typeGistDescription();
        });

        And("^user type gist file name$", () -> {
            GitStepsPage.typeGistFileName();
        });

        And("^user type gist content$", () -> {
            GitStepsPage.typeContentGist();
        });

        Then("^user should be redirect to new gist page$", () -> {
            GitStepsPage.isNewGistPublicExist();
        });

        And("^user click on list gists$", () -> {
            GitStepsPage.clickOnListGists();
        });

        And("^user edit gist description$", () -> {
            GitStepsPage.editGistDesc();
        });

        Then("^user should be redirect to update gist page$", () -> {
            GitStepsPage.isRedirectToUpdateGist();
        });

        Then("^user should redirect to list of gists$", () -> {
            GitStepsPage.showListOfGists();
        });
    }


}
