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
	
	public void getTitle() {
		System.out.println("Git Hub is launched : "+ driver.getCurrentUrl() + ", title: " +driver.getTitle());
	}
	
	public void getGitMessage() {
		System.out.println(gitmesages.getText());
	}
	
	

}
