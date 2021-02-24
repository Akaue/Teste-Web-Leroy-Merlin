package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected static WebDriver driver;
	
	//instancia webdriver
	public BasePage(WebDriver driver) {
		
		BasePage.driver = driver;
	}
	

}
