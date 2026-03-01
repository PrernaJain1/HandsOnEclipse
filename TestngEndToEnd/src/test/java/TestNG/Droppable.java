package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Config.ConfigReader;

public class Droppable {
	WebDriver driver;
	ConfigReader r;
	
	@BeforeMethod
	public void dropPreCond() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		r=new ConfigReader();
		driver.get(r.getData("url_drop"));
	}
	@Test
	public void drop() throws InterruptedException {
		driver.switchTo().frame(0); //By index
		Actions a=new Actions(driver);
		WebElement dragMe=driver.findElement(By.id("draggable"));
		WebElement dropHere=driver.findElement(By.id("droppable"));
		a.dragAndDrop(dragMe, dropHere).build().perform();
		Thread.sleep(5000);
		System.out.println(dropHere.getText());
		
	}
	@AfterMethod
	public void dropPost() {
		driver.quit();
	}
}
