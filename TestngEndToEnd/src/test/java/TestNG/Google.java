package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Config.ConfigReader;

@Listeners
public class Google {
	
	WebDriver driver;
	ConfigReader r;
	
	@BeforeMethod
	public void precondn() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		r=new ConfigReader();
		driver.get(r.getData("url"));	
	}
	
	@Test
	public void search() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("google");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='btnK'])[1]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//h3[text()='Google'])[1]")).getText());
		
		
	}
	
	@AfterMethod
	public void postcond() {
		driver.quit();
	}
}
