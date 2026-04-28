package prac1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class practiceParameters {

	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	@Parameters({"userName","emailId"})
	public void test(String name, String email) throws InterruptedException {
		System.out.println(name + " "+ email);
		driver.findElement(By.id("userName")).sendKeys(name);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		Thread.sleep(5000);
	}

	@AfterClass
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}


}
