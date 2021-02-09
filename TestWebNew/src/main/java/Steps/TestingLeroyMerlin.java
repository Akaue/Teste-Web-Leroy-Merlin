package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LocationPage;
import Pages.StorePage;
import Support.AccessBrowserPage;

public class TestingLeroyMerlin {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = AccessBrowserPage.CreateBrowser();
		LocationPage selecionarLocal = new LocationPage(driver);
		selecionarLocal.locationAccess("São Paulo");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	// Escolher 3 produtos e ir para o caixa
	@Test
	public void chooseAndCart() throws InterruptedException {

		StorePage selecionandoProduto = new StorePage(driver);
		selecionandoProduto.searchProduct("Dispensador");
		selecionandoProduto.chooseProduct();
		
		String validandoProdutoEscolhido = driver.findElement(By.xpath("//h1[@class=\"product-title align-left color-text product-description\"]")).getText();
		Assert.assertEquals("Dispenser para Sabonete Líquido e Álcool em Gel Plástico 400ml Compacta Premisse", validandoProdutoEscolhido);
	}

	// testando login errado

	public void wrongLoginTest() throws InterruptedException {
		StorePage loginErrado = new StorePage(driver);
		loginErrado.wrongLogin("AkaueLima", "Senha aleatoria");

		String validandoButton = driver.findElement(By.xpath("//*[contains(text(), 'Entrar')]")).getText();
		Assert.assertEquals(validandoButton, "Entrar");

//		String mensagem = driver.findElement(By.className("feedback-title")).getText();
//		Assert.assertEquals(mensagem,"Ops! Alguma coisa está errada.");

	}

}
