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
		selecionarLocal.locationAccess("S�o Paulo");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	// Escolher produtos e ir para o caixa

	public void chooseAndCart() throws InterruptedException {

		StorePage selecionandoProduto = new StorePage(driver);
		selecionandoProduto.searchProduct("Dispensador");
		selecionandoProduto.chooseProduct();

		// primeira forma
		String validandoProdutoEscolhido = driver
				.findElement(By.xpath("//h1[@class=\"product-title align-left color-text product-description\"]"))
				.getText();

		Assert.assertEquals("Dispenser para Sabonete L�quido e �lcool em Gel Pl�stico 400ml Compacta Premisse",
				validandoProdutoEscolhido);

		CartPage carrinho = new CartPage(driver);
		carrinho.finalizingPurchase();

	}

	// testando login errado

	public void wrongLoginTest() throws InterruptedException {
		StorePage cliqueBot�o = new StorePage(driver);
		cliqueBot�o.btnLogin();
		StorePage loginErrado = new StorePage(driver);
		loginErrado.wrongLogin("AkaueLima", "Senha aleatoria");

		String validandoButton = driver.findElement(By.xpath("//*[contains(text(), 'Entrar')]")).getText();
		Assert.assertEquals(validandoButton, "Entrar");

//		String mensagem = driver.findElement(By.className("feedback-title")).getText();
//		Assert.assertEquals(mensagem,"Ops! Alguma coisa est� errada.");

	}

	@Test
	public void registerAccountTest() throws InterruptedException {

		StorePage clickLogin = new StorePage(driver);
		clickLogin.btnLogin();

		CartPage clickBtnRegistro = new CartPage(driver);
		clickBtnRegistro.btnRegister();

		AccountPage registroConta = new AccountPage(driver);
		registroConta.registerAccount("930.651.650-90");

		String valida��oPagina = driver.findElement(By.xpath("//*[contains(text(),'Bem-vindo � Leroy Merlin')]"))
				.getText();
		Assert.assertEquals(valida��oPagina, "Bem-vindo � Leroy Merlin");

	}

//	@Test
//	public void suiteTeste() throws InterruptedException {
//		chooseAndCart();
//		registerAccountTest();
//		wrongLoginTest();
//		
//	}

}
