package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

	public StorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public StorePage btnLogin() {
		driver.findElement(By.xpath("//i[@class='glyph glyph-silhouette']")).click();
		driver.findElement(By.className("user-login-button")).click();
		return this;

	}

	// Login com email e pass que n�o existem teste negativo
	public StorePage wrongLogin(String login, String pass) throws InterruptedException {

		driver.findElement(By.id("email")).sendKeys(login);
		driver.findElement(By.id("password")).sendKeys(pass);
//		driver.findElement(By.className("float-right")).click();
		Thread.sleep(5000);

		return this;

	}

	public StorePage searchProduct(String produto) throws InterruptedException {
		driver.findElement(By.xpath("//*[@class=\"search-input\"]")).sendKeys(produto);
		driver.findElement(By.xpath("//*[@class=\"search-button color-neutral\"]")).click();
		Thread.sleep(5000);

		return this;

	}

	// selecionando produtos de home office
	public CartPage chooseProduct() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");

		driver.findElement(By.xpath("//div[contains(text(),'Dispensador Autom�tico Para Copo Descart�vel De �g')]"))
				.click();
		Thread.sleep(3000);

		return new CartPage(driver);

	}

	public String validaButton() {
		return driver.findElement(By.xpath("//*[@class=\"button button-full button-primary margin-top align-left\"]")).getText();
				
	}

	public String validaProdutoTexto() {
		return driver.findElement(By.xpath("//*[@class=\"product-title align-left color-text product-description\"]"))
				.getText();
	}
			

}
