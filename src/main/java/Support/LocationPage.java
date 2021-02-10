package Support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.BasePage;
import Pages.StorePage;


public class LocationPage extends BasePage{


	public LocationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public StorePage locationAccess(String cidade) throws InterruptedException {

		String mensagem = driver.findElement(By.xpath("//p[@class]")).getText();
		Assert.assertEquals("Dessa forma você terá acesso aos produtos e ofertas da sua região.", mensagem);
		System.out.println(mensagem);

		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(cidade);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='Suggestion-bkx3x4-7 hkAiIc']//span")).click();
		driver.findElement(By.xpath("//button[@class='BaseStyle-tp17g3-0 iMiGVp']")).click();

		Thread.sleep(5000);

		 return new StorePage(driver);
	}

}
