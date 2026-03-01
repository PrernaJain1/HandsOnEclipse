package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Config.ConfigReader;
public class DropDown {
	WebDriver driver;
	ConfigReader r;
	
	@BeforeMethod
	public void dropPreCond() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		r=new ConfigReader();
		driver.get(r.getData("url_global"));
		
	}
	@Test
	public void dropDown() throws InterruptedException {
		WebElement e=driver.findElement(By.xpath("//div[contains(@class,'single_tab')]//p//select"));
		Select s= new Select(e);
		s.selectByVisibleText("India");
		Thread.sleep(5000);
		s.selectByValue("ALB");
		Thread.sleep(5000);
	}
	@AfterMethod
	public void dropPostCond() {
		driver.quit();
	}
}
