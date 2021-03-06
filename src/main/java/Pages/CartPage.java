package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public CartPage finalizingPurchase() throws InterruptedException {

		driver.findElement(By.xpath("//*[@data-component=\"add-to-cart\"]")).click();

		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class=\"Button-y1xsg2-0 ButtonPrimary-y1xsg2-1 kNzlbA\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"postal-code\"]")).sendKeys("06852470");
		Thread.sleep(10000);

		return this;

	}
	
	
	
	public AccountPage btnRegister() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[contains(text(),'Cadastrar')]")).click();
		Thread.sleep(4000);
		
		return new AccountPage(driver);
	}

}
