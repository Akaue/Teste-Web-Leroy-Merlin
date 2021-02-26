package Steps;

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
	AddLocation selecionarLocal = new AddLocation(driver);
	StorePage storePage = new StorePage(driver);
	CartPage cartPage = new CartPage(driver);
	AccountPage accountPage = new AccountPage(driver);

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = AccessWeb.CreateBrowser();
		selecionarLocal.locationAccess("São Paulo");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	// Escolher produtos e ir para o caixa
	@Test
	public void chooseAndCartTest() throws InterruptedException {

		storePage.searchProduct("Dispensador");
		storePage.chooseProduct();

		Assert.assertEquals("Dispenser para Sabonete Líquido e Álcool em Gel Plástico 400ml Compacta Premisse",
				storePage.validaProdutoTexto());
		cartPage.finalizingPurchase();

	}

	// testando login errado
	@Test
	public void wrongLoginTest() throws InterruptedException {

		storePage.btnLogin();
		storePage.wrongLogin("AkaueLima", "Senha aleatoria");
		Assert.assertEquals("Entrar", storePage.validaButton());

//		String mensagem = driver.findElement(By.className("feedback-title")).getText();
//		Assert.assertEquals(mensagem,"Ops! Alguma coisa está errada.");

	}

	// testando registro de conta
	@Test
	public void registerAccountTest() throws InterruptedException {
		storePage.btnLogin();
		cartPage.btnRegister();
		accountPage.registerAccount("930.651.650-90");

		Assert.assertEquals("Bem-vindo à Leroy Merlin", accountPage.validaPagina());

	}

}
