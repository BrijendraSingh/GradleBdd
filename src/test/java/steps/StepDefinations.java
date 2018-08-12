package steps;

import PageClasses.GitHub;
import cucumber.api.java.en.Given;

public class StepDefinations {
	@Given("^User launch git$")
	public void user_launch_git() throws Throwable {
		GitHub git = new GitHub();
		git.getTitle();
	}

	@Given("^User read the git welcome message$")
	public void user_read_the_git_welcome_message() throws Throwable {
	  new GitHub().getGitMessage();
	}
}
