package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
	
public static WebDriver driver;
	
	public WebDriver setBrowser (String browser ) {			
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "MOZILA":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
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
	//System.out.println(driver.toString());
	return driver;
	}
	
	public String readConfig(String key) {
		String value=null;
		File file = new File(System.getProperty("user.dir") + "/src/test/java/UserDefaultProperty.properties");				
		try {
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			value= prop.getProperty(key);
		}		
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
}
