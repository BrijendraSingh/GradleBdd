package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static WebDriver driver;
	static Scenario report;

	@Before
	public void testSetup(Scenario sce) {
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
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sce.embed(screenshot, "image/png"); // ... and embed it in the report.
		}
		driver.close();
		sce.write("Closed the browser: " + driver.toString());
	}

	public static Scenario getReporter() {
		return report;
	}

	public WebDriver setBrowser(String browser) {
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "MOZILA":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			break;
		case "NEW":
			break;
		default:
			System.out.println(browser + "Not found");
			break;
		}
		// System.out.println(driver.toString());
		return driver;
	}

	public String readConfig(String key) {
		String value = null;
		File file = new File(System.getProperty("user.dir") + "/src/test/java/UserDefaultProperty.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
}
