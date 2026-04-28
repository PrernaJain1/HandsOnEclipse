package demoqa;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class WidgetsSlider {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//To run code in in-cognito mode
		options.addArguments("--incognito");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/slider");

		Thread.sleep(5000);
		WebElement slider = driver.findElement(By.xpath("//input[contains(@class,'range-slider')]"));
		Actions a = new Actions(driver);
		a.moveToElement(slider).clickAndHold().moveByOffset(81,0).release().build().perform();
		System.out.println("slider moved");
		Thread.sleep(5000);
		//Take screenshot
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f,new File("C:\\Users\\91914\\Downloads\\Practice\\ss.png"));
		System.out.print("Screenshot captured");
		driver.quit();
	}

}
