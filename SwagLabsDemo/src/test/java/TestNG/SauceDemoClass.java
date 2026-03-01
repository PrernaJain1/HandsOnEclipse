package TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Config.ConfigReader;

@Listeners
public class SauceDemoClass {
	public static WebDriver driver;
	ConfigReader r;
	
	@BeforeMethod
	public void preCondn() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		r= new ConfigReader();
		driver.get(r.getData("url"));
	}
	
	@Test
	public void loginSauceDemo() {
		//login();
	}
	
	@Test(dependsOnMethods = "loginSauceDemo")
	public void placeOrder() {
		//placingOrder();
	}
	
	@AfterMethod
	public void postCond() {
		driver.quit();
	}
}
