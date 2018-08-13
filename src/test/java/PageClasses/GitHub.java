package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericUtils;


public class GitHub extends GenericUtils {
	
	public WebDriver driver;

	@FindBy(xpath="//h1[text()='Built for developers']/following-sibling::p")
	WebElement gitmesages;
	
	public GitHub() {
		this.driver = super.driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void launchGit(){
		driver.navigate().to("https://github.com/");
		reporter.write("url launched: " + driver.getCurrentUrl());
		takeSreenshot();
	}
	public void getTitle() {
		System.out.println("Git Hub is launched : "+ driver.getCurrentUrl() + ", title: " +driver.getTitle());
		//takeSreenshot();
	}
	
	public void getGitMessage() {
		System.out.println(gitmesages.getText());
		reporter.write(gitmesages.getText());
		takeSreenshot();
	}
	
	

}
