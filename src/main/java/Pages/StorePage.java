package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class StorePage extends BasePage {

	public StorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Faker faker = new Faker();
	String nome = faker.name().fullName();
	String numero = faker.phoneNumber().cellPhone();
			
	public StorePage btnRegister(String CPF) throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'Cadastrar')]"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.id("cpf-cnpj")).sendKeys(CPF);
		driver.findElement(By.id("name")).sendKeys(nome);
		driver.findElement(By.id("phone")).sendKeys(numero);
		driver.findElement(By.id("email")).sendKeys("astrobaldo@hotmail.com");
		driver.findElement(By.id("confirm_email")).sendKeys("astrobaldo@hotmail.com");
		driver.findElement(By.id("password")).sendKeys("Quin321Xd");
		driver.findElement(By.id("confirm_password")).sendKeys("Quin321Xd");
		driver.findElement(By.id("privacy_and_usage_terms-pf")).click();
		
		// teste quebra por causa da validação robo
//		driver.findElement(By.xpath("//*[contains(text(),'Continuar')]")).click();
		Thread.sleep(10000);
		
		
		
	
			
		
		
		// botao logo
//		driver.findElement(By.xpath("//a[@class=\"header-logo\"]")).click();

		return this;
	}

	public StorePage btnLogin() {
		driver.findElement(By.xpath("//i[@class='glyph glyph-silhouette']")).click();
		driver.findElement(By.className("user-login-button")).click();
		return this;

	}

	// Login com email e pass que não existem teste negativo
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

		driver.findElement(By.xpath(
				"//*[@class=\"col-xs-6 col-sm-12\"]//*[contains(text(),'Dispenser para Sabonete Líquido 400ml Compacta')]"))
				.click();
		Thread.sleep(3000);

		return new CartPage(driver);

	}

}
