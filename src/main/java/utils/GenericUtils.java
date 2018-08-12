package utils;

import org.openqa.selenium.WebDriver;

import core.Hooks;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils () {
		this.driver=Hooks.driver;		
	}

}
