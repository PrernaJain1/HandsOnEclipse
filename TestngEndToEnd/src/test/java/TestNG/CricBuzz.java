package TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Config.ConfigReader;
import POM.CricHomePage;
import POM.CricStats;

@Listeners
public class CricBuzz {
	public static WebDriver driver;
	ConfigReader r;
	CricHomePage c;
	CricStats s;
	
	@BeforeMethod
	public void cricpre() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		c=new CricHomePage(driver);
		s=new CricStats(driver);
		r=new ConfigReader();
		driver.get(r.getData("url_cric"));
	}
	
	@Test(enabled = true)
	public void cricsearch() throws InterruptedException {
		c.moveToSeries();
		
		//To get all the links
		c.printLinks();
		}
	
	@Test
	public void cricClick() throws InterruptedException{
		c.moveToSeries();
		c.btnClickEngTour();
		s.Stats();	
	}
	
	@AfterMethod
	public void cricpost() {
		driver.quit();
	}
	
}
