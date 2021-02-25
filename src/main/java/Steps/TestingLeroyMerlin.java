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
	@Test
	public void chooseAndCartTest() throws InterruptedException {

		StorePage selecionandoProduto = new StorePage(driver);
		selecionandoProduto.searchProduct("Dispensador");
		selecionandoProduto.chooseProduct();

		Assert.assertEquals("Dispenser para Sabonete L�quido e �lcool em Gel Pl�stico 400ml Compacta Premisse",
				selecionandoProduto.validaProdutoTexto());

		CartPage carrinho = new CartPage(driver);
		carrinho.finalizingPurchase();

	}

	// testando login errado	
	@Test
	public void wrongLoginTest() throws InterruptedException {
		StorePage cliqueBot�o = new StorePage(driver);
		cliqueBot�o.btnLogin();
		StorePage loginErrado = new StorePage(driver);
		loginErrado.wrongLogin("AkaueLima", "Senha aleatoria");	

		Assert.assertEquals("Entrar", loginErrado.validaButton());

//		String mensagem = driver.findElement(By.className("feedback-title")).getText();
//		Assert.assertEquals(mensagem,"Ops! Alguma coisa est� errada.");

	}

	// testando registro de conta
	@Test
	public void registerAccountTest() throws InterruptedException {

		StorePage clickLogin = new StorePage(driver);
		clickLogin.btnLogin();

		CartPage clickBtnRegistro = new CartPage(driver);
		clickBtnRegistro.btnRegister();

		AccountPage registroConta = new AccountPage(driver);
		registroConta.registerAccount("930.651.650-90");

		Assert.assertEquals("Bem-vindo � Leroy Merlin", registroConta.validaPagina());

	}

}
