package steps;

import org.openqa.selenium.WebDriver;

import core.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Annotations extends Hooks {
	WebDriver driver;

	@Before
	public void testConfigSetup(Scenario sce) {
		/*
		System.out.println("****************BEFORE-Start*********************");
		System.out.println(sce.getName() + " Started");
		*/
		
		String browser = System.getProperty("selenium.browser");
		if (browser != null) {
			driver = setBrowser(System.getProperty("selenium.browser"));
		} else {
			driver = setBrowser(readConfig("browser"));
		}
		
		driver.navigate().to("https://github.com/");
		/*
		System.out.println("****************BEFORE-End*********************");
		System.out.println("");
		*/
	}

	@After
	public void teardown(Scenario sce) {
		/*
		System.out.println("****************AFTER-Start*********************8");
		System.out.println(sce.getName() + " Completed");
		*/
		driver.close();
		/*
		System.out.println("****************AFTER-End*********************");
		System.out.println("");
		*/
	}
}
