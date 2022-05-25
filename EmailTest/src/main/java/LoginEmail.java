import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginEmail {

	@Test
	public void emailValido() throws InterruptedException {
		//instância criada para chamar o driver do chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bruno\\OneDrive\\Documentos\\Driver\\chromedriver.exe");
		
		//chamando o driver
		WebDriver driver = new ChromeDriver();
		
		//passando os parâmetros para o email
		driver.get("http://www.gmail.com");
		
		//maximizando a tela
		driver.manage().window().maximize();
		
		//passando os parâmetros da label através do ID do campo e enviando o email como parâmetro
		driver.findElement(By.id("identifierId")).sendKeys("e7700091@gmail.com");
		
		//xpath do caminho do botão para seguir
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"))
				.click();
		
		//aguardando 3 segundos para carregar a página
		Thread.sleep(3000);
		
		//xpath do caminho da label da senha e passando os parâmetros da senha
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Kkk123456");
		//clicando no ENTER
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys(Keys.ENTER);
		
		//aguarda 5 segundos para carregar a tela
		Thread.sleep(5000);
		
		//pegando o texto da tela quando abre o email para comparar com o valor esperado
		String atual = driver.findElement(By.xpath("//div[@class='OS']")).getText();
		
		//valor esperado
		String esperado = "Get started with Gmail";
		
		//comparação do valor esperado com o atual - teste OK
		assertEquals(esperado, atual);
		//fechando a tela de navegação
		driver.close();
	}

	//passando para o segundo teste
	@Test
	public void emailInvalido() throws InterruptedException {
		//a mesma iniciação do driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bruno\\OneDrive\\Documentos\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//entrando no email
		driver.get("http://www.gmail.com");
		
		//maximiza a tela
		driver.manage().window().maximize();
		
		//entrando com um email inválido
		driver.findElement(By.id("identifierId")).sendKeys("asdasd");
		
		//clicando no botão para seguir
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"))
				.click();
		//aguardando 2 segundos para carregar a tela
		Thread.sleep(2000);
		
		//pegando o texto da tela para comparar com o esperado
		String atual = driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
		//valor esperado
		String esperado = "Não foi possível encontrar sua Conta do Google";
		
		//comparação do valor esperado com o atual
		assertEquals(esperado, atual);
		
		//fechando a tela - teste OK
		driver.close();
		
	}
	//iniciando último teste do LOGIN
	@Test
	public void senhaInvalida () throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bruno\\OneDrive\\Documentos\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		
		driver.manage().window().maximize();
		
		//entrando com o email válido
		driver.findElement(By.id("identifierId")).sendKeys("e7700091@gmail.com");
		
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"))
				.click();
		
		Thread.sleep(3000);
		//entrando com uma senha inválida
		//coloquei em uma string a senha para testar como outro cenário
		String senhainvalida = "12das!34";
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys(senhainvalida);
		//ENTER
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys(Keys.ENTER);
			//aguarda 3 sgundos
		Thread.sleep(3000);
		
		//pega elemento da tela para comparar com o valor esperado
		String atual = driver.findElement(By.xpath("//div[@jsname='B34EJ']")).getText();
		
		String esperado = "Senha incorreta. Tente novamente ou clique em \"Esqueceu a senha?\" para escolher uma outra.";
		assertEquals(esperado, atual);
		//comparação correta - teste OK, finaliza primeiro teste
		driver.close();
		
	}

}
