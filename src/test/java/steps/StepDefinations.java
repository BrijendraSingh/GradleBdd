package steps;

import org.junit.Assert;

import PageClasses.GitHub;
import cucumber.api.java.en.Given;

public class StepDefinations {
	@Given("^User launch git$")
	public void user_launch_git() throws Throwable {
		GitHub git = new GitHub();
		git.launchGit();
		git.getTitle();
	}

	@Given("^User read the git welcome message$")
	public void user_read_the_git_welcome_message() throws Throwable {
	  new GitHub().getGitMessage();
	  Assert.fail();
	}

	@Given("User launch google news")
	public void user_launch_google_news() {
	    System.out.println("Google news launched");
	}

	@Given("User read the google news")
	public void user_read_the_google_news() {
    	System.out.println("Reading the google news..");
	}
}
