package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.ConfigReader;
public class Resizable {
	WebDriver driver;
	ConfigReader r;
	
	@BeforeTest
	public void resizePreCond() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		r=new ConfigReader();
		driver.get(r.getData("url_resize"));
	}
	
	@Test
	public void resize() throws InterruptedException {
		driver.switchTo().frame(0);
		Actions a=new Actions(driver);
		WebElement ele= driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-se')]"));
		
		//a.dragAndDropBy(ele,144,80).build().perform();
		a.moveToElement(ele).clickAndHold().moveByOffset(144, 80).release().build().perform();
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void resizePostCond() {
		driver.quit();
	}
	
}
