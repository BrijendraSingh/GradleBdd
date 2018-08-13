package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import framework.Hooks;
import cucumber.api.Scenario;
import steps.Annotations;

public class GenericUtils {
	
	public WebDriver driver;
	public Scenario reporter;
	
	public GenericUtils () {
		this.driver=Hooks.driver;	
		reporter = Annotations.getReporter();
	}
	
	public void takeSreenshot() {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		reporter.embed(screenshot, "image/png");
	}

}
