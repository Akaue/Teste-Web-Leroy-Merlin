package Support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessBrowserPage {
	
	public static WebDriver CreateBrowser() {
	
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Dimension dimension = new Dimension(1350, 700);
		driver.manage().window().setSize(dimension);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.leroymerlin.com.br/localizacao");		
		
		
		return driver;	
		
	}

}
