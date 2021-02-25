package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Faker faker = new Faker();
	String nome = faker.name().fullName();
	String numero = faker.phoneNumber().cellPhone();

	public AccountPage registerAccount(String CPF) throws InterruptedException {
		
		driver.findElement(By.id("cpf-cnpj")).sendKeys(CPF);
		driver.findElement(By.id("name")).sendKeys(nome);
		driver.findElement(By.id("phone")).sendKeys(numero);
		driver.findElement(By.id("email")).sendKeys("astrobaldo@hotmail.com");
		driver.findElement(By.id("confirm_email")).sendKeys("astrobaldo@hotmail.com");
		driver.findElement(By.id("password")).sendKeys("Quin321Xd");
		driver.findElement(By.id("confirm_password")).sendKeys("Quin321Xd");
		driver.findElement(By.id("privacy_and_usage_terms-pf")).click();

		// teste quebra por causa da validação robo
//	driver.findElement(By.xpath("//*[contains(text(),'Continuar')]")).click();
		Thread.sleep(10000);

		// botao logo
//	driver.findElement(By.xpath("//a[@class=\"header-logo\"]")).click();

		return this;
	}
	
	public	String validaPagina() {
		 return driver.findElement(By.xpath("//*[contains(text(),'Bem-vindo à Leroy Merlin')]")).getText();
	}

}