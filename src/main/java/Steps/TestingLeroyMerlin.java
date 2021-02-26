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

	public WebDriver driver;

	public StorePage storePage = new StorePage(driver);
	public CartPage cartPage = new CartPage(driver);
	public AccountPage accountPage = new AccountPage(driver);

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = AccessWeb.CreateBrowser();
		AddLocation addLocation = new AddLocation(driver);
		addLocation.locationAccess("S�o Paulo");

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

		Assert.assertEquals("Dispensador Autom�tico Para Copo Descart�vel De �gua E Caf�",
				storePage.validaProdutoTexto());
		cartPage.finalizingPurchase();

	}

	// login errado
	@Test
	public void wrongLoginTest() throws InterruptedException {

		storePage.btnLogin();
		storePage.wrongLogin("AkaueLima", "Senha aleatoria");
		Assert.assertEquals("Entrar", storePage.validaButton());

		// Captcha robo impede valida��o correta
//		String mensagem = driver.findElement(By.className("//*[@class=\"feedback feedback-error margin-top-double\"]"))
//				.getText();
//		Assert.assertEquals("Ops! Alguma coisa est� errada.", mensagem);

	}

	// registro de conta
	@Test
	public void registerAccountTest() throws InterruptedException {
		storePage.btnLogin();
		cartPage.btnRegister();
		accountPage.registerAccount("930.651.650-90");

		Assert.assertEquals("Bem-vindo � Leroy Merlin", accountPage.validaPagina());

	}

}
