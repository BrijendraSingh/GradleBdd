package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import framework.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Annotations extends Hooks {

	WebDriver driver;
	public static Scenario report;

	@Before
	public void testSetup(Scenario sce) {

		report = sce;
		String browser = System.getProperty("selenium.browser");
		if (browser != null) {
			driver = setBrowser(System.getProperty("selenium.browser"));
		} else {
			driver = setBrowser(readConfig("browser"));
		}
		sce.write("Driver launched: " + driver.toString());

	}

	@After
	public void teardown(Scenario sce) {

		if (sce.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sce.embed(screenshot, "image/png");
		}
		driver.close();
		sce.write("Closed the browser: " + driver.toString());

	}

	public static Scenario getReporter() {
		return report;
	}
}
