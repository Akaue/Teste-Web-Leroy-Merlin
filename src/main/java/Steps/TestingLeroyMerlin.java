package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.AccountPage;
import Pages.CartPage;
import Pages.StorePage;

import Support.AccessWeb;
import Support.AddLocation;



public class TestingLeroyMerlin {


  WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = AccessWeb.CreateBrowser();
		AddLocation selecionarLocal = new AddLocation(driver);
		selecionarLocal.locationAccess("São Paulo");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	// Escolher produtos e ir para o caixa
	@Test
	public void chooseAndCartTest() throws InterruptedException {

		StorePage selecionandoProduto = new StorePage(driver);
		selecionandoProduto.searchProduct("Dispensador");
		selecionandoProduto.chooseProduct();

		String validaProdutoTexto = driver.findElement(By.xpath("//h1[@class=\"product-title align-left color-text product-description\"]"))
		.getText();
		Assert.assertEquals("Dispenser para Sabonete Líquido e Álcool em Gel Plástico 400ml Compacta Premisse",
				validaProdutoTexto);

		CartPage carrinho = new CartPage(driver);
		carrinho.finalizingPurchase();

	}

	// testando login errado

	public void wrongLoginTest() throws InterruptedException {
		StorePage cliqueBotão = new StorePage(driver);
		cliqueBotão.btnLogin();
		StorePage loginErrado = new StorePage(driver);
		loginErrado.wrongLogin("AkaueLima", "Senha aleatoria");

		String validaButton = driver.findElement(By.xpath("//h1[@class=\"product-title align-left color-text product-description\"]"))
		.getText();

		Assert.assertEquals(validaButton, "Entrar");

//		String mensagem = driver.findElement(By.className("feedback-title")).getText();
//		Assert.assertEquals(mensagem,"Ops! Alguma coisa está errada.");

	}

	
	public void registerAccountTest() throws InterruptedException {

		StorePage clickLogin = new StorePage(driver);
		clickLogin.btnLogin();

		CartPage clickBtnRegistro = new CartPage(driver);
		clickBtnRegistro.btnRegister();

		AccountPage registroConta = new AccountPage(driver);
		registroConta.registerAccount("930.651.650-90");

		String validaPagina = driver.findElement(By.xpath("//*[contains(text(),'Bem-vindo à Leroy Merlin')]")).getText();
    	Assert.assertEquals(validaPagina, "Bem-vindo à Leroy Merlin");

	}

}
