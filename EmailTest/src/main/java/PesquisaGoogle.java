import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PesquisaGoogle {
//segundo teste utilizando o google
	@Test
	public void pesquisaQualquer() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bruno\\OneDrive\\Documentos\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		//abrindo o navegador da mesma forma, mas passando o parâmetro do google
		
		//através do xpath passei o parâmetro da minha pesquisa
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("seplag ce");
		
		//ENTER - Passou 1ª teste
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
		driver.close();
		
	}
	
	//Início do 2º teste
	@Test
	public void pesquisaAvancada() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bruno\\OneDrive\\Documentos\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		//utilizando uma pesquisa avançada usando google search tips
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("site:folha.uol.com.br ayrton senna");
		//ENTER
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
		driver.close();
		
	}
	//Iniciando 3º teste
	@Test
	public void semResultados () {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bruno\\OneDrive\\Documentos\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		//usando parâmetros com um valor que não irá retornar nada
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("!x!x!x!x.oasd!@#asdXAS123\\xz");
		//ENTER
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
		
		//através do xpath comparamos o valor do texto que foi passado na tela
		String atual = driver.findElement(By.xpath("//div[@class='v3jTId']")).getText();
		
		//comparamos com o valor esperado
		String esperado = "Sua pesquisa não encontrou nenhum documento correspondente";
		assertEquals(esperado, atual);
		driver.close();
		//teste OK
		
	}
}
